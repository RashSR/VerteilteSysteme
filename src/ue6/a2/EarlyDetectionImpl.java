package ue6.a2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class EarlyDetectionImpl implements EarlyDetectionIF {

    @Override
    public ReportIF analyze(XRayPicture picture) throws RemoteException {
        Report report = new Report(picture);
        report.setDate(new Date());
        report.setDiagnose("ServerDiagnose");
        report.setProceedFurther("Do more sports.");

        ReportIF reportStub = (ReportIF) UnicastRemoteObject.exportObject(report, 0);

        return reportStub;
    }
}
