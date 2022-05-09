package ue6.a3;

import java.rmi.RemoteException;

public class EarlyDetectionImpl implements EarlyDetectionIF {

    @Override
    public void analyze(XRayPicture picture, CallbackIF reference) throws RemoteException, InterruptedException {
        Report report = new Report(picture);
        Thread t = new Thread(new AnalyzeAsync(report, reference));
        t.start();
    }
}
