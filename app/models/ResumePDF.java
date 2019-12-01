package models;

import io.ebean.Model;
import io.ebean.*;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.format.*;
import play.data.validation.*;

import java.util.*;

@Entity
public class ResumePDF extends Model {

    @Id
    private long pdfID;

    private long linkedResume;

    private String pdfAWSPath;

    public static final Finder<Long, ResumePDF> find = new Finder<>(ResumePDF.class);

    public long getPdfID () {
        return pdfID;
    }

    public long getLinkedResume() {
        return linkedResume;
    }

    public String getPdfAWSPath() {
        return pdfAWSPath;
    }

    public void setLinkedResume(long newLinkedResume) {
        linkedResume = newLinkedResume;
    }

    public void setPdfAWSPath(String newPdfAWSPath) {
        pdfAWSPath = newPdfAWSPath;
    }
}