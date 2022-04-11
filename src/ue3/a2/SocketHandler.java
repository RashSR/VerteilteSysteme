package ue3.a2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

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
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html");
        writer.println("Content-Length: 74");
        writer.println();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Hallo Welt!!!</h1>");
        writer.println("Es hat geklappt");
        writer.println("</body>");
        writer.println("</html>");

        writer.flush();
    }
}
