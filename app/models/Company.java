package models;

import io.ebean.Model;
import io.ebean.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company extends Model {

    @Id
    public long companyID;

    @Column(columnDefinition = "varchar(30) not null")
    public String companyName;

}