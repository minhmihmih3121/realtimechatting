/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class multiServer {
    private static int port = 5000;
    private static ServerSocket serverSocket = null;
    public static Vector<server> servers = new Vector<>();
    public static Vector<server> serversWait = new Vector<>();
    public static PublicKey publicKey;
    public static String strPublicKey;
    public static PrivateKey privateKey;
    public static String strPrivateKey;
    public static void main(String[] args) {
        ExecutorService excutor = Executors.newCachedThreadPool();
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port " + port);
            while (true){
                Socket socket = serverSocket.accept();
                server client = new server(socket, "@");
                servers.add(client);
                excutor.execute(client);
            }
        } catch (SocketException e){
            System.out.println("Client exit");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
