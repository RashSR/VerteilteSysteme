package ue6.a2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EarlyDetectionIF extends Remote {
    public Report analyze(XRayPicture picture) throws RemoteException;
}
