package models;

import io.ebean.Model;
import io.ebean.*;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.format.*;
import play.data.validation.*;

import java.util.*;

@Entity
public class Resume extends Model {

    @Id
    private long resumeID;

    private long companyID;

    public static final Finder<Long, Resume> find = new Finder<>(Resume.class);

    public long getResumeID() {
        return resumeID;
    }

    public long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(long companyID) {
        this.companyID = companyID;
    }
}