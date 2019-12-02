package controllers;

import models.*;
import play.mvc.*;
import views.html.*;
import play.data.FormFactory;
import play.api.Play;
import play.data.Form;
import javax.inject.Inject;
import com.typesafe.config.Config;
import java.util.List;
import java.io.File;
import play.libs.Files.TemporaryFile;
import java.util.ArrayList;
import io.ebean.Model;
import play.libs.Json;
import play.libs.Json.*;
import com.amazonaws.auth.*;
import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.amazonaws.AmazonServiceException;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class UploadController extends Controller {

    private final Config config;
    @Inject
    FormFactory formFactory;

    @Inject
    public UploadController(Config config) {
        this.config = config;
    }


    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    public Result uploadPage() {
        System.out.println("Going to upload page");
        List<Company> companies = Company.find.all();
        return ok(upload.render(companies));
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

    public Result getResumes() {
        List<Resume> resumes = Resume.find.all();
        return ok(Json.toJson(resumes));
    }
}