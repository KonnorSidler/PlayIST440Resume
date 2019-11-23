package models;

import io.ebean.Model;
import io.ebean.*;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.format.*;
import play.data.validation.*;

import java.util.*;

@Entity
public class Skills extends Model {

    public long linkedResume;

    public String skillField;

    public static final Finder<Long, Skills> find = new Finder<>(Skills.class);

    public void setLinkedResume(long resumeID) {
        linkedResume = resumeID;
    }

    public void setSkillField(String newSkills) {
        skillField = newSkills;
    }

    public long getLinkedResume() {
        return linkedResume;
    }

    public String getSkills() {
        return skillField;
    }
}