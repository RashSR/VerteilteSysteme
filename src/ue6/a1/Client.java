package ue6.a1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        EarlyDetectionIF earlyDetection = (EarlyDetectionIF) registry.lookup("Key");
        XRayPicture xRayPicture = new XRayPicture("Achim Roskopf");
        Report report = earlyDetection.analyze(xRayPicture);

        System.out.println("Diagnose: " + report.getDiagnose() + ", " + report.getDate());
        System.out.println("further Procedure: " + report.getProceedFurther());
    }
}
