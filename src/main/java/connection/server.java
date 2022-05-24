package connection;
import Model.Message;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class server implements Runnable{
    private Socket s = null;
    private String connectWith = "@";
    private BufferedReader in = null;
    private BufferedWriter out = null;
    private boolean isRunning = false;
    private String myName = "";
    public Vector<String> refuse = new Vector<>();
    public server(Socket socket, String name) throws IOException {
        this.s = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        this.myName = name;
        this.isRunning = true;
    }

    @Override
    public void run() {
        try {
            System.out.println("A new guy "+s.getInetAddress()+" has joined to server with port "+s.getPort());
            out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while(isRunning){
                String line;
                line = in.readLine();
                System.out.println("Client sent: "+line);
                handle(toMessage(line));
            }
            
            
        }
        catch(IOException ex)
        {
            System.err.println(ex.getMessage());
        }
    }
    
    private Message toMessage(String s) {
        Gson gson = new Gson();
        Type objectType = new TypeToken<Message>(){}.getType();
        Message mes = gson.fromJson(s,objectType);
        return mes;
    }
    private void handle(Message mes) {
        switch (mes.getOption()) {
            case "send": {
                System.out.println("Option send: " + s.getPort()+" to: "+this.connectWith);
                for (server ser: multiServer.servers) {
                    if (ser.getMyName().equals(this.connectWith)) {
                        Message m = new Message("receive",mes.getMessage());
                        ser.sendMessage(m.exchangeJSON(m));
                        System.out.println("Server send to:" + ser.s.getPort()+" option: "+m.getOption());
                        break;
                    }
                }
                break;
            }
            case "connect": {
                System.out.println("Option connect: " + s.getPort()+" to: "+mes.getMessage());
                boolean kt=false;
                for (server ser: multiServer.servers) {
                    if (ser.getMyName().equals(mes.getMessage())) {
                        kt=true;
                        Message m = new Message("wantConnect",this.getMyName());
                        ser.sendMessage(m.exchangeJSON(m));
                        System.out.println("Server send to:" + ser.s.getPort()+" option: "+m.getOption());
                        break;
                    }
                }     
                if (!kt){
                    Message m = new Message("connectF",mes.getMessage());
                    sendMessage(m.exchangeJSON(m));
                    System.out.println("Server send to:" + s.getPort()+" option: "+m.getOption());
                }
                break;
            }
            case "acceptConnect": {
                System.out.println("Option acceptConnect: " + s.getPort()+" with: "+mes.getMessage());
                this.connectWith = mes.getMessage();
                Message m = new Message("connectA",mes.getMessage());
                sendMessage(m.exchangeJSON(m));
                try {
                    refuse.remove(m.getMessage());
                } catch (Exception e) {
                }
                System.out.println("Server send to:" + s.getPort()+" option: "+m.getOption());
                for (server ser: multiServer.servers) {
                        if (ser.getMyName().equals(mes.getMessage())) {
                            try {
                                multiServer.serversWait.remove(ser);
                                ser.refuse.remove(myName);
                            } catch (Exception e) {
                            }
                            ser.connectWith = this.getMyName();
                            m = new Message("connectA",this.getMyName());
                            ser.sendMessage(m.exchangeJSON(m));
                            System.out.println("Server send to:" + ser.s.getPort()+" option: "+m.getOption());
                            break;
                        }
                    }     
                try {
                    multiServer.serversWait.remove(this);
                } catch (Exception e) {
                    
                }
                break;
            }
            case "denyConnect": {
                System.out.println("Option denyConnect: " + s.getPort()+" with: "+mes.getMessage());
                refuse.add(mes.getMessage());
                for (server ser: multiServer.servers) {
                    if (ser.getMyName().equals(mes.getMessage())) {
                        Message m = new Message("connectD",this.getMyName());
                        ser.sendMessage(m.exchangeJSON(m));
                        System.out.println("Server send to:" + ser.s.getPort()+" option: "+m.getOption());
                        break;
                    }
                }
                break;
            }
            case "addFuse": {
                System.out.println("Option addFuse: " + s.getPort()+" with: "+mes.getMessage());
                if (!refuse.contains(mes.getMessage())) {
                    refuse.add(mes.getMessage());
                }
                break;
            }
            case "disconnect": {
                System.out.println("Option disconnect: " + s.getPort()+" with: "+mes.getMessage());
                for (server ser: multiServer.servers) {
                    if (ser.getMyName().equals(this.connectWith)) {
                        Message m = new Message("disconnect",this.getMyName());
                        ser.sendMessage(m.exchangeJSON(m));
                        System.out.println("Server send to:" + ser.s.getPort()+" option: "+m.getOption());
                        ser.connectWith = "@";
                        this.connectWith = "@";
                        m = new Message("disconnected",ser.getMyName());
                        sendMessage(m.exchangeJSON(m));
                        break;
                    }
                }
                break;
            }
            case "check": {
                System.out.println("Option check nickname: " + s.getPort()+ " " + mes.getMessage());
                String kt="true";
                for (server s: multiServer.servers) {
                    if (s.myName.equals(mes.getMessage())) {
                        kt="false";
                        break;
                    }
                }
                sendMessage(kt);
                if (kt.equals("true")){
                    this.myName=mes.getMessage();
                }
                break;
            }
            case "random": {
                System.out.println("Option random: " + s.getPort());
                boolean kt = true;
                Message m;
                for (server ser: multiServer.serversWait) {                    
                    if(!refuse.contains(ser.myName)&&!ser.refuse.contains(myName)&&!ser.myName.equals(myName)) {
                        m = new Message("randomS",ser.getMyName());
                        sendMessage(m.exchangeJSON(m));
                        System.out.println("Server send to:" + s.getPort()+" option: "+m.getOption());
                        kt = false;
                        System.out.println("random true.");
                        break;
                    }
                }
                if (kt) {
                    m = new Message("randomF","false");
                    sendMessage(m.exchangeJSON(m));
                    System.out.println("Server send to:" + s.getPort()+" option: "+m.getOption());
                    System.out.println("random false.");
                }
                break;
            }
            case "exit": {
                System.out.println("Option exit: " + s.getPort());
                if (!this.getConnectWith().equals("@")) {
                    for (server ser: multiServer.servers) {
                        if (ser.getMyName().equals(this.connectWith)) {
                            Message m = new Message("disconnectOut",this.getMyName());
                            ser.sendMessage(m.exchangeJSON(m));
                            System.out.println("Server send to:" + ser.s.getPort()+" option: "+m.getOption());
                            ser.connectWith = "@";
                            break;
                        }
                    }
                }
                multiServer.servers.remove(this);
                try {
                    multiServer.serversWait.remove(this);
                } catch (Exception e) {
                }
                this.close();
                break;
            }
            case "joinWait": {
                System.out.println("Option joinWait: " + s.getPort());
                Message m;
                boolean kt =true;
                for (server ser: multiServer.serversWait) {
                    if (ser.getMyName().equals(myName)) {
                        kt=false;
                        break;
                    }
                }
                if (kt) {
                    multiServer.serversWait.add(this);
                    if (!this.connectWith.equals("@")) {
                        Message message = new Message("disconnect",this.getConnectWith());
                        handle(message);
                    }
                    m = new Message("joinWaitS","");
                    sendMessage(m.exchangeJSON(m));
                    System.out.println("Server send to:" + s.getPort()+" option: "+m.getOption());
                }
                else {
                    m = new Message("joinWaitF","");
                    sendMessage(m.exchangeJSON(m));
                    System.out.println("Server send to:" + s.getPort()+" option: "+m.getOption());
                }
                break;
            }
            case "leaveWait": {
                System.out.println("Option leaveWait: " + s.getPort());
                if(multiServer.serversWait.remove(this)) {
                    Message m = new Message("leaveWaitS",this.myName);
                    sendMessage(m.exchangeJSON(m));
                    System.out.println("Server send to:" + s.getPort()+" option: "+m.getOption());
                }
                else {
                    Message m = new Message("leaveWaitF",this.myName);
                    sendMessage(m.exchangeJSON(m));
                    System.out.println("Server send to:" + s.getPort()+" option: "+m.getOption());
                }
                break;
            }
            case "sendF": {
                System.out.println("Option sendF to: " + s.getPort()+" from: "+mes.getMessage());
                for (server ser: multiServer.servers) {
                    if (ser.getMyName().equals(mes.getMessage())) {
                        Message m = new Message("sendF",this.myName);
                        ser.sendMessage(m.exchangeJSON(m));
                        System.out.println("Server send to:" + ser.s.getPort()+" option: "+m.getOption());
                        break;
                    }   
                }
                break;
            }   
            case "deleteRefuse": {
                try {
                    System.out.println("Option deleteRefuse from: " + s.getPort());
                    this.refuse.clear();
                    Message m = new Message("deleteRefuseS","");
                    sendMessage(m.exchangeJSON(m));
                    System.out.println("Server send to:" + s.getPort()+" option: "+m.getOption());
                } catch (Exception e) {
                    Message m = new Message("deleteRefuseF","");
                    sendMessage(m.exchangeJSON(m));
                    System.out.println("Server send to:" + s.getPort()+" option: "+m.getOption());
                }
                break;
                
            }
            case "find": {
                boolean kt = false;
                for (server ser: multiServer.servers) {
                    if (ser.getMyName().equals(mes.getMessage())){
                        kt=true;
                        if (!ser.refuse.contains(myName)) {
                            if (ser.connectWith.equals("@")){
                                Message m = new Message("findS",ser.myName);
                                sendMessage(m.exchangeJSON(m));
                                System.out.println("Server send to:" + s.getPort()+" option: "+m.getOption()); 
                            }
                            else {
                                Message m = new Message("findB",ser.myName);
                                sendMessage(m.exchangeJSON(m));
                                System.out.println("Server send to:" + s.getPort()+" option: "+m.getOption());
                                m = new Message("ConnectW",this.myName);
                                sendMessage(m.exchangeJSON(m));
                                System.out.println("Server send to:" + ser.s.getPort()+" option: "+m.getOption());
                            }
                        }
                        else {
                            Message m = new Message("findD",ser.myName);
                            sendMessage(m.exchangeJSON(m));
                            System.out.println("Server send to:" + s.getPort()+" option: "+m.getOption());
                        }
                        break;
                    } 
                }
                if (!kt) {
                    Message m = new Message("findF",mes.getMessage());
                    sendMessage(m.exchangeJSON(m));
                    System.out.println("Server send to:" + s.getPort()+" option: "+m.getOption());
                }
                break;
            }
        }
    }
    
    public void close() {
        try {
            System.out.println("client in port "+s.getPort()+" is out");
            in.close();
            out.close();
            s.close();
        } catch (Exception e) {
        }
    }
    
    public void sendMessage(String mes) {
        try {
            out.write(mes);
            out.newLine();
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void sendMessageTo(int port, String mes) {
        try {
            (multiServer.servers.get(port)).out.write(mes);
            (multiServer.servers.get(port)).out.newLine();
            (multiServer.servers.get(port)).out.flush();
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    public String getConnectWith() {
        return connectWith;
    }

    public void setConnectWith(String connectWith) {
        this.connectWith = connectWith;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }
    
    public Socket getS() {
        return s;
    }
}
