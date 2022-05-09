package ue6.a3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EarlyDetectionIF extends Remote {
    public void analyze(XRayPicture picture, CallbackIF reference) throws RemoteException, InterruptedException;
}
