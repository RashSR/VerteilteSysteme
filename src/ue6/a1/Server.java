package ue6.a1;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        EarlyDetectionIF earlyDetection = new EarlyDetectionImpl();
        EarlyDetectionIF stub = (EarlyDetectionIF) UnicastRemoteObject.exportObject(earlyDetection, 0);
        Registry registry = LocateRegistry.createRegistry(1099);

        registry.bind("Key-ue1", stub);
    }
}
