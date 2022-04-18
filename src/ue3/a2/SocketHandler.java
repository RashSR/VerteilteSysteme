package ue3.a2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SocketHandler implements Runnable{

    private Socket socket;

    public SocketHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream out = null;
        try {
            out = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = new PrintWriter(out);
        try {
            List<String> lines = Files.readAllLines(Paths.get("./Resources/index.html"));
            for(String line : lines){
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.flush();
    }
}
