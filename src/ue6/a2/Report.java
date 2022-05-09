package ue6.a2;

import java.io.Serializable;
import java.util.Date;

public class Report implements ReportIF {

    private Date date;
    private String diagnose;
    private String proceedFurther;

    public Report(){
        
    }

    public Report(XRayPicture picture){
        diagnose = "Bad stuff";
        proceedFurther =  "The patient has to take medication.";
        date = picture.getPictureFrom();
    }

    public Date getDate() { return date; }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getProceedFurther() {
        return proceedFurther;
    }

    public void setProceedFurther(String proceedFurther) {
        this.proceedFurther = proceedFurther;
    }
}
