package models;

import io.ebean.Model;
import io.ebean.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company extends Model {

    @Id
    public long companyID;

    public String companyName;

}