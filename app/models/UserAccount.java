package models;

import io.ebean.Model;
import io.ebean.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAccount extends Model {

    @Id
    public long userID;

    @Column(columnDefinition = "varchar(30) not null")
    public String userEmail;

    @Column(columnDefinition = "varchar(30) not null")
    public String userName;

}