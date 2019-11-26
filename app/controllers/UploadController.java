package controllers;

import models.*;
import play.mvc.*;
import views.html.*;
import play.data.FormFactory;
import play.data.Form;
import javax.inject.Inject;
import java.util.List;
import java.util.ArrayList;
import io.ebean.Model;
import play.libs.Json;
import play.libs.Json.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class UploadController extends Controller {
    @Inject
    FormFactory formFactory;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index(long resumeID) {
        System.out.println("Going to upload edit index");
        return ok(resumeEdit.render(resumeID));
    }

    public Result uploadPage() {
        System.out.println("Going to upload page");
        List<Company> companies = Company.find.all();
        return ok(upload.render(companies));
    }

    public Result companyCreatePage() {
        System.out.println("Going to company creation page");
        return ok(company.render());
    }

    public Result viewResume(long resumeID) {
        List<Clubs> clubs = Clubs.find.query().where().eq("linkedResume", resumeID).findList();
        List<Interning> internships = Interning.find.query().where().eq("linkedResume", resumeID).findList();
        List<Schooling> schools = Schooling.find.query().where().eq("linkedResume", resumeID).findList();
        List<Skills> skills = Skills.find.query().where().eq("linkedResume", resumeID).findList();
        return ok(viewResume.render(clubs, internships, schools, skills, resumeID));
    }

    public Result addClubToResume(Http.Request request) {
        System.out.println("Adding Club to Resume");
        JsonNode json = request.body().asJson();
        System.out.println(json);
        Clubs newClub = new Clubs();
        newClub.setClubName(json.findPath("clubName").textValue());
        newClub.setClubDesc(json.findPath("clubDescription").textValue());
        newClub.setLinkedResume(Long.valueOf(json.findPath("resumeID").textValue()));
        System.out.println(newClub.getName() + "||" + newClub.getLinkedResume() + "||" + newClub.getDesc());
        newClub.save();
        return ok(resumeEdit.render(Long.valueOf(json.findPath("resumeID").textValue())));
    }

    public Result addInternshipToResume(Http.Request request) {
        System.out.println("Adding Internship to Resume");
        JsonNode json = request.body().asJson();
        System.out.println(json);
        Interning newInternship = new Interning();
        newInternship.setInternCompany(json.findPath("internCompany").textValue());
        newInternship.setDescription(json.findPath("internDesc").textValue());
        newInternship.setLinkedResume(Long.valueOf(json.findPath("resumeID").textValue()));
        newInternship.setPosition(json.findPath("internPosition").textValue());
        System.out.println(newInternship.toString());
        newInternship.save();
        return ok(resumeEdit.render(Long.valueOf(json.findPath("resumeID").textValue())));
    }

    public Result addSchoolToResume(Http.Request request) {
        System.out.println("Adding School to Resume");
        JsonNode json = request.body().asJson();
        System.out.println(json);
        Schooling newSchool = new Schooling();
        newSchool.setSchoolName(json.findPath("schoolName").textValue());
        newSchool.setMajor(json.findPath("schoolMajor").textValue());
        newSchool.setLinkedResume(Long.valueOf(json.findPath("resumeID").textValue()));
        System.out.println(newSchool.toString());
        newSchool.save();
        return ok(resumeEdit.render(Long.valueOf(json.findPath("resumeID").textValue())));
    }

    public Result addSkillsToResume(Http.Request request) {
        System.out.println("Adding Skills to Resume");
        JsonNode json = request.body().asJson();
        System.out.println(json);
        Skills newSkills = new Skills();
        newSkills.setSkillField(json.findPath("skillField").textValue());
        newSkills.setLinkedResume(Long.valueOf(json.findPath("resumeID").textValue()));
        System.out.println(newSkills.toString());
        newSkills.save();
        return ok(resumeEdit.render(Long.valueOf(json.findPath("resumeID").textValue())));
    }

    public Result createResumeObject(Http.Request request) {
        System.out.println("Creating Resume Object");
        JsonNode json = request.body().asJson();
        System.out.println(json);
        Resume newResume = new Resume();
        Company company;
        if (!(Company.find.query().where().eq("companyName", json.findPath("companyName").textValue()).findOne() == null)) {
            company = Company.find.query().where().eq("companyName", json.findPath("companyName").textValue()).findOne();
        } else {
            createCompanyFromResume(json.findPath("companyName").textValue());
            company = Company.find.query().where().eq("companyName", json.findPath("companyName").textValue()).findOne();
        }
        newResume.setCompanyID(company.getCompanyID());
        newResume.save();
        long resumeID = newResume.getResumeID();
        return ok(Long.toString(resumeID));
    }

    public void createCompanyFromResume(String newCompanyName) {
        Company newCompany = new Company();
        newCompany.setCompanyName(newCompanyName);
        newCompany.save();
    }

    public Result createCompanyObject(Http.Request request) {
        System.out.println("Creating Company Object");
        JsonNode json = request.body().asJson();
        System.out.println(json);
        Company newCompany = new Company();
        newCompany.setCompanyName(json.findPath("companyName").textValue());
        newCompany.save();
        List<Company> companies = Company.find.all();
        return ok(upload.render(companies));
    }

    public Result getClubs() {
        List<Clubs> clubs = Clubs.find.all();
        return ok(Json.toJson(clubs));
    }

    public Result getInternships() {
        List<Interning> internships = Interning.find.all();
        return ok(Json.toJson(internships));
    }

    public Result getSchools() {
        List<Schooling> schools = Schooling.find.all();
        return ok(Json.toJson(schools));
    }

    public Result getSkills() {
        List<Skills> skills = Skills.find.all();
        return ok(Json.toJson(skills));
    }

    public Result getResumes() {
        List<Resume> resumes = Resume.find.all();
        return ok(Json.toJson(resumes));
    }
}