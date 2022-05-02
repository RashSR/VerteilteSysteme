package ue6.a1;

import java.rmi.RemoteException;

public class EarlyDetectionImpl implements EarlyDetectionIF {

    @Override
    public Report analyze(XRayPicture picture) throws RemoteException {
        Report report = new Report(picture);
        return report;
    }
}
