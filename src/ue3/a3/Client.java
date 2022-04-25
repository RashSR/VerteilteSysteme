package ue3.a3;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket server = new Socket("localhost", 1001);

            Runnable keyboardListener = new KeyInputListener(server);
            new Thread(keyboardListener).start();
            Runnable inputStreamListener = new ServerInputListener(server);
            new Thread(inputStreamListener).start();

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
