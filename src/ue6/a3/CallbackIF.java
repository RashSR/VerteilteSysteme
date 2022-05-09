package ue6.a3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CallbackIF extends Remote {
    public void setReport(Report report) throws RemoteException;
}
