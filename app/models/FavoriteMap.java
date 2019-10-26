package models;

import io.ebean.Model;
import io.ebean.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FavoriteMap extends Model {

    @ManyToOne()
    public UserAccount userAccount;

    @ManyToOne()
    public Company company;

}