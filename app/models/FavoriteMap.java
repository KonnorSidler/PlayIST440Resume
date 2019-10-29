package models;

import io.ebean.Model;
import io.ebean.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FavoriteMap extends Model {

    public UserAccount userAccount;

    public Company company;

}