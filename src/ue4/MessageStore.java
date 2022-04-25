package ue4;

import java.util.HashMap;

public class MessageStore {
    private HashMap<String, String> userMessages;
    private final Object monitor = new Object();

    public MessageStore(){
        this.userMessages = new HashMap<>();
    }

    public void addUser(String newUserName){
        synchronized (monitor){
            while(userMessages == null){
                try{
                    monitor.wait();
                }catch(InterruptedException e){

                }
            }
            if(!userMessages.containsKey(newUserName)) {
                userMessages.put(newUserName, "");
                System.out.println("Created User: " + newUserName);
            }else{
                System.out.println("The User " + newUserName + " already exists.");
            }
            monitor.notifyAll();
        }
    }

    public void sendMessageToUser(String sendingUserName, String receivingUserName, String message){
        synchronized (monitor){
            while(userMessages == null){
                try{
                    monitor.wait();
                }catch(InterruptedException e){

                }
            }
            if(userMessages.containsKey(sendingUserName) && userMessages.containsKey(receivingUserName)) {
                String messages = userMessages.get(receivingUserName);
                messages += message + "; ";
                userMessages.put(receivingUserName, messages);
                System.out.println(sendingUserName + " sends " + receivingUserName + " the message: " + message);
            }else{
                System.out.println("Both User has to be registered.");
            }
            monitor.notifyAll();
        }
    }

    public String getMessagesForUser(String userName){
        String message = "";
        synchronized (monitor){
            while(userMessages == null){
                try{
                    monitor.wait();
                }catch (InterruptedException e){

                }
            }
            if(userMessages.containsKey(userName)){
                message = userMessages.get(userName);
                System.out.println(userName + " has following Messages: " + message);
            }else{
                System.out.println("User " + userName + " is not registered.");
            }
            monitor.notifyAll();
        }
        return message;
    }
}
