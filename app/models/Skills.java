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

    private long linkedResume;

    private String skillField;

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

    public String getSkillField() {
        return skillField;
    }
}