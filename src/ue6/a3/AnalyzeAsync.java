package ue6.a3;

import java.rmi.RemoteException;

public class AnalyzeAsync implements Runnable{

    private Report report;
    private CallbackIF reference;

    public AnalyzeAsync(Report report, CallbackIF reference){
        this.reference = reference;
        this.report = report;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            reference.setReport(report);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
