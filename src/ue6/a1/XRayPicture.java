package ue6.a1;

import java.io.Serializable;
import java.util.Date;

public class XRayPicture implements XRayPictureIF {

    private Date pictureFrom;
    private transient String patientName;
    private byte[] rawData;

    public XRayPicture(String patientName){
        this.patientName = patientName;
        pictureFrom = new Date();
    }

    public Date getPictureFrom() {
        return pictureFrom;
    }

    public void setPictureFrom(Date pictureFrom) {
        this.pictureFrom = pictureFrom;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public byte[] getRawData() {
        return rawData;
    }

    public void setRawData(byte[] rawData) {
        this.rawData = rawData;
    }
}
