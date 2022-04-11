package ue3.a1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{

            Socket s = new Socket("localhost", 1234);

            System.out.println("Bitte geben Sie eine Nachricht ein:");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            OutputStream out = s.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            writer.println(userInput);
            writer.flush();

            InputStream in = s.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            System.out.println("Antwort von Server: " + reader.readLine());

        }catch(IOException ex){

        }
    }
}
