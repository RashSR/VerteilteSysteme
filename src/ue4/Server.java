package ue4;

import ue3.a2.SocketHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(10);
        MessageStore messageStore = new MessageStore();

        try(ServerSocket serverSocket = new ServerSocket(1001)){
            while(true) {
                Socket s = serverSocket.accept();
                System.out.println("Neue Verbindung von Client");
                es.execute(new MessagingService(messageStore, s));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
