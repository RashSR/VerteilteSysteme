package ue6.a1;

import java.rmi.RemoteException;
import java.util.Date;

public class EarlyDetectionImpl implements EarlyDetectionIF {

    @Override
    public Report analyze(XRayPictureIF picture) throws RemoteException {
        Report report = new Report();
        report.setDate(new Date());
        return report;
    }

}
