package ue6.a1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EarlyDetectionIF extends Remote {
    public Report analyze(XRayPicture picture) throws RemoteException;
}
