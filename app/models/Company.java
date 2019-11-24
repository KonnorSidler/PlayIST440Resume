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

    public static final Finder<Long, Company> find = new Finder<>(Company.class);

    public long getCompanyID() {
        return companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

//public class CompanyFinder extends Finder {
//    public CompanyFinder() {
//        super (Company.class);
//    }
//
//    public long returnIDByName(String searchCompanyName) {
//        Company searchedCompany = query.eq("companyName", searchCompanyName).findOne();
//        return searchedCompany.getCompanyID();
//    }
//
//    public String returnNameByID(long searchResumeID) {
//        Company searchedCompany = query.eq("companyID", searchResumeID).findOne();
//        return searchedCompany.getCompanyName();
//    }
//}