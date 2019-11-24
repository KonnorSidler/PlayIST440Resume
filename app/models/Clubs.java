package models;

import io.ebean.Model;
import io.ebean.*;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.format.*;
import play.data.validation.*;

import java.util.*;

@Entity
public class Clubs extends Model {

    private long linkedResume;

    private String clubName;

    private String clubDescription;

    public static final Finder<Long, Clubs> find = new Finder<>(Clubs.class);

    public void setLinkedResume(long resumeID) {
        linkedResume = resumeID;
    }

    public void setClubName(String newClubName) {
        clubName = newClubName;
    }

    public void setClubDesc(String newClubDesc) {
        clubDescription = newClubDesc;
    }

    public String getName() {
        return clubName;
    }

    public String getDesc() {
        return clubDescription;
    }

    public long getLinkedResume() {
        return linkedResume;
    }

}