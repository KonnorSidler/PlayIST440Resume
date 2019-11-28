package models;

import io.ebean.Model;
import io.ebean.*;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.format.*;
import play.data.validation.*;

import java.util.*;

@Entity
public class Schooling extends Model {

    @Id
    public long schoolID;

    public long linkedResume;

    public String schoolName;

    public String major;

    public static final Finder<Long, Schooling> find = new Finder<>(Schooling.class);

    public long getID() {
        return schoolID;
    }

    public void setLinkedResume(long resumeID) {
        linkedResume = resumeID;
    }

    public void setSchoolName(String newSchoolName) {
        schoolName = newSchoolName;
    }

    public void setMajor(String newMajor) {
        major = newMajor;
    }

    public long getLinkedResume() {
        return linkedResume;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getMajor() {
        return major;
    }


}