package ue4;

import java.io.*;
import java.net.Socket;

public class MessagingService implements Runnable{

    private MessageStore messageStore;
    private Socket socket;


    public MessagingService(MessageStore messageStore, Socket socket){
        this.messageStore = messageStore;
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            writer.println("Usage:");
            writer.println("REG<Username>");
            writer.println("SND<SenderName>#<ReceiverName>#Message");
            writer.println("RCV<Username>");
            writer.flush();

            String input = reader.readLine();

            if(input.startsWith("REG")){

                String userName = input.substring(3);
                messageStore.addUser(userName);

            }else if(input.startsWith("SND")){

                String[] parameter = input.split("#");

                messageStore.sendMessageToUser(parameter[0].substring(3), parameter[1], parameter[2]);

            }else if(input.startsWith("RCV")){

                String userName = input.substring(3);
                writer.println(messageStore.getMessagesForUser(userName));
                writer.flush();

            }else{
                writer.println("Wrong Usage!");
                writer.flush();
            }
            writer.close();
            reader.close();
            socket.close();
        }catch (IOException e){

        }
    }
}
