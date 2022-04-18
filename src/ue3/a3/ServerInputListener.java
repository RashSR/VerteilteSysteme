package ue3.a3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerInputListener implements Runnable{

    private Socket socket;

    public ServerInputListener(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String input;
            do{
                input = reader.readLine();
                System.out.println("[Other] " + input);
            }while(input != null && !input.equalsIgnoreCase( "Bye"));

            socket.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
