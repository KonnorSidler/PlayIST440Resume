package models;

import io.ebean.Model;
import io.ebean.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resume extends Model {

    @Id
    public long resumeID;

    @ManyToOne()
    public Company company;

    @Column(columnDefinition = "varchar(100) not null")
    public String resumeS3Path;

    @Column(columnDefinition = "varchar(50) not null")
    public Date resumeUploadDate;

}