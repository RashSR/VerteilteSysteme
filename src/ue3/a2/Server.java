package ue3.a2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(10);

        try(ServerSocket serverSocket = new ServerSocket(80)){
            while(true) {
                Socket s = serverSocket.accept();
                System.out.println("Neue Verbindung von Browser");
                es.execute(new SocketHandler(s));
                //new Thread(new SocketHandler(s)).start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
