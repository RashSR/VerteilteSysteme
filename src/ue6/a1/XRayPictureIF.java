package ue6.a1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface XRayPictureIF extends Remote {

    Date getPictureFrom() throws RemoteException;
    void setPictureFrom(Date pictureFrom) throws RemoteException;

    String getPatientName() throws RemoteException;
    void setPatientName(String patientName) throws RemoteException;

    byte[] getRawData() throws RemoteException;
    void setRawData(byte[] rawData) throws RemoteException;

}
