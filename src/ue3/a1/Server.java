package ue3.a1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args){
        int port = 1234;
        String clientName = "Test";

        try(ServerSocket serverSocket = new ServerSocket(port)){
            while(true){
                Socket s = serverSocket.accept();
                System.out.println("Neue Verbindung von: " + clientName + s.getRemoteSocketAddress());

                InputStream in = s.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String incomingMessage = reader.readLine();

                System.out.println("Nachricht vom Client: " + incomingMessage);

                OutputStream out = s.getOutputStream();
                PrintWriter writer = new PrintWriter(out);
                writer.println(incomingMessage);
                writer.flush();
            }

        }catch(IOException e){

        }
    }
}
