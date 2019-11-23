package models;

import io.ebean.Model;
import io.ebean.*;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.format.*;
import play.data.validation.*;

import java.util.*;

@Entity
public class Interning extends Model {

    private long linkedResume;

    private String internCompany;

    private String position;

    private String description;

    public static final Finder<Long, Interning> find = new Finder<>(Interning.class);

    public void setLinkedResume(long resumeID) {
        linkedResume = resumeID;
    }

    public void setInternCompany(String newInternCompany) {
        internCompany = newInternCompany;
    }

    public void setPosition(String newInternPos) {
        position = newInternPos;
    }

    public void setDescription(String newInternDesc) {
        description = newInternDesc;
    }

    public long getLinkedResume() {
        return linkedResume;
    }

    public String getInternCompany() {
        return internCompany;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }



}