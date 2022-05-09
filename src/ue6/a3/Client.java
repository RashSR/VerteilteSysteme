package ue6.a3;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client implements CallbackIF{
    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {

        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        EarlyDetectionIF earlyDetection = (EarlyDetectionIF) registry.lookup("Key-ue3");
        XRayPicture xRayPicture = new XRayPicture("Achim Roskopf");

        CallbackIF c = new Client();
        CallbackIF callbackStub = (CallbackIF) UnicastRemoteObject.exportObject(c, 0);
        earlyDetection.analyze(xRayPicture, callbackStub);
        Thread.sleep(2000);
        earlyDetection.analyze(xRayPicture, callbackStub);

    }

    @Override
    public void setReport(Report report) throws RemoteException {
        System.out.println("Diagnose: " + report.getDiagnose() + ", " + report.getDate());
        System.out.println("further Procedure: " + report.getProceedFurther());
    }
}
