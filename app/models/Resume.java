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
    public long resumeID;

    public Company company;

    public String resumeS3Path;

    @Formats.DateTime(pattern="dd/MM/yyyy")
    public Date resumeUploadDate = new Date();

}