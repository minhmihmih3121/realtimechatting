package connection;
import Model.Message;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clientExecute /*implements Runnable*/{
    private Socket s = null;
    private BufferedReader stdIn = null;
    public BufferedReader in = null;
    public BufferedWriter out = null;
    private boolean isConnected = false;
    public clientExecute(String host, int port)
    {
        try{
            s = new Socket(host,port);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            isConnected = true;
            System.out.println("You have been connected to "+s.getInetAddress()+" with port "+s.getPort());
        }catch(java.io.IOException ex)
        {
            System.err.println(ex.getMessage());
        }
    }
//    @Override
//    public void run()
//    {
//        try{
//            while(true)
//            {
//                String clientSend;
//                clientSend = stdIn.readLine();
//                sendMessage(clientSend);
//                System.out.println("You sent: "+clientSend);
//                System.out.println("Server sent: "+in.readLine());              
//            }
//            
//        }
//        catch(IOException | NullPointerException ex){
//            System.err.println(ex.getMessage());
//        }
//    }
    
    public void close() {
        try {
            out.close();
            in.close();
            s.close();
        } catch (Exception e) {
        }
    }
    
    public boolean sendMessage(String message)
    {
        if(isConnected)
        {
            try {
                System.out.println("Input from client: "+message+"\n");
                out.write(message+"\n");
                out.flush();
                System.out.println("Client send: "+message+"\n");
                return true;
            } catch (Exception e) {
                Logger.getLogger(clientExecute.class.getName()).log(Level.SEVERE, null, e);
                return false;
            }
        }
        return false;
    }
    
    public String getMessage() {
        try {
            return in.readLine();
        } catch (Exception e) {
            return "";
        }
    }
    public boolean isConnected() {
        return this.isConnected;
    }
    
    public int getPort() {
        return s.getPort();
    }
    public static void main(String[] args)
    {
        connection.clientExecute client1 = new connection.clientExecute("127.0.0.1",5000);
        //client1.run();
    }
}
