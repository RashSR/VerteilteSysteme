package ue3.a3;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class KeyInputListener implements Runnable{
    private Socket socket;

    public KeyInputListener(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            String input = null;
            Scanner sc = new Scanner(System.in);
            do{
                input = sc.nextLine();
                writer.println(input);
                writer.flush();
            }while(input != null && !input.equalsIgnoreCase( "Bye"));

            socket.close();
            sc.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
