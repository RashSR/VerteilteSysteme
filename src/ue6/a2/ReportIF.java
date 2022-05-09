package ue6.a2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface ReportIF extends Remote {

    public Date getDate() throws RemoteException;

    public void setDate(Date date) throws RemoteException;

    public String getDiagnose() throws RemoteException;

    public void setDiagnose(String diagnose) throws RemoteException;

    public String getProceedFurther() throws RemoteException;

    public void setProceedFurther(String proceedFurther) throws RemoteException;
}
