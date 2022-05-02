package ue6.a1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        EarlyDetectionIF serverStub = (EarlyDetectionIF) registry.lookup("Key-ue1");

        XRayPicture xRayPicture = new XRayPicture("Achim Roskopf");
        XRayPictureIF xrayStub = (XRayPictureIF) UnicastRemoteObject.exportObject(xRayPicture, 0);

        Report report = serverStub.analyze(xRayPicture);

        System.out.println("Diagnose: " + report.getDiagnose() + ", " + report.getDate());
        System.out.println("further Procedure: " + report.getProceedFurther());
    }
}
