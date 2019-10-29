package models;

import io.ebean.Model;
import io.ebean.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAccount extends Model {

    @Id
    public long userID;

    public String userEmail;

    public String userName;

}