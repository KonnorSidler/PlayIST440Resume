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
    public Result index(long resumeID) {
        System.out.println("Going to upload edit index");
        List<Clubs> clubs = Clubs.find.query().where().eq("linkedResume", resumeID).findList();
        List<Interning> internships = Interning.find.query().where().eq("linkedResume", resumeID).findList();
        List<Schooling> schools = Schooling.find.query().where().eq("linkedResume", resumeID).findList();
        List<Skills> skills = Skills.find.query().where().eq("linkedResume", resumeID).findList();
        List<ResumePDF> pdfs = ResumePDF.find.query().where().eq("linkedResume", resumeID).findList();
        return ok(resumeEdit.render(clubs, internships, schools, skills, pdfs,  resumeID));
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
        List<ResumePDF> pdfs = ResumePDF.find.query().where().eq("linkedResume", resumeID).findList();
        return ok(viewResume.render(clubs, internships, schools, skills, pdfs, resumeID));
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
        return ok(json.findPath("resumeID").textValue());
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
        return ok(json.findPath("resumeID").textValue());
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
        return ok(json.findPath("resumeID").textValue());
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
        return ok(json.findPath("resumeID").textValue());
    }

    public Result deleteObject(Http.Request request) {
        System.out.println("Deleting object in handler");
        JsonNode json = request.body().asJson();
        System.out.println(json);
        String objectType = json.findPath("objectType").textValue();
        long id;

        switch (objectType){
            case "club":
                id = json.findPath("objectID").longValue();
                Clubs.find.deleteById(id);
                break;
            case "internship":
                id = json.findPath("objectID").longValue();
                Interning.find.deleteById(id);
                break;
            case "school":
                id = json.findPath("objectID").longValue();
                Schooling.find.deleteById(id);
                break;
            case "skill":
                id = json.findPath("objectID").longValue();
                Skills.find.deleteById(id);;
                break;
            default:
                System.out.println("ObjectType not recognized");
        }

        return ok(json.findPath("resumeID").textValue());
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

    public Result uploadFileToS3(Http.Request request, long resumeID) {
        Http.MultipartFormData<TemporaryFile> body = request.body().asMultipartFormData();
        Http.MultipartFormData.FilePart<TemporaryFile> pdf = body.getFile("pdf");

        if (pdf != null) {
            try {
                System.out.println("Trying to pull ref from file");
                TemporaryFile tempFile = pdf.getRef();
                System.out.println("Temp File Made");
                File file = tempFile.path().toFile();
                System.out.println("File Made from Temp File");
                String filename = pdf.getFilename();
                System.out.println("File Name Made");

                String accessKey = config.getString("aws.access.key");
                String secret = config.getString("aws.secret.key");
                String bucketName = config.getString("aws.bucketName");

                System.out.println(accessKey + " " + secret + " " + bucketName);


                try {
                    AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secret);
                    AmazonS3 s3Client = new AmazonS3Client(awsCredentials);
                    AccessControlList acl = new AccessControlList();
                    acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
                    s3Client.createBucket(bucketName);
                    s3Client.putObject(new PutObjectRequest(bucketName, filename, file).withAccessControlList(acl));

                    String pdfFilePath = "http://" + bucketName+ ".s3.amazonaws.com/" + filename;
                    ResumePDF newPDF = new ResumePDF();
                    newPDF.setLinkedResume(resumeID);
                    newPDF.setPdfAWSPath(pdfFilePath);
                    newPDF.setBucketName(bucketName);
                    newPDF.setKeyName(filename);
                    newPDF.save();

                    return redirect("/resume/edit/resume=" + resumeID);
                } catch (Exception e) {
                    System.out.println("Error After Creds");
                    e.printStackTrace();
                    return ok("Resume was not uploaded");
                }

            } catch(Exception e) {
                return internalServerError(e.getMessage());
            }
        } else {
            System.out.println("Missed the Try Block");
            return badRequest();
        }
    }

    public Result deletePDF(Http.Request request) {
        JsonNode json = request.body().asJson();
        long pdfID = json.findPath("pdfID").longValue();
        System.out.println("Deleting pdf " + pdfID);
        String accessKey = config.getString("aws.access.key");
        String secret = config.getString("aws.secret.key");
        try {
            AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secret);
            AmazonS3 s3Client = new AmazonS3Client(awsCredentials);
            ResumePDF resume = ResumePDF.find.byId(pdfID);
//            AccessControlList acl = new AccessControlList();
//            acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
//            s3Client.createBucket(bucketName);
//            s3Client.putObject(new PutObjectRequest(bucketName, filename, file).withAccessControlList(acl));
            s3Client.deleteObject(new DeleteObjectRequest(resume.getBucketName(), resume.getKeyName()));
            ResumePDF.find.deleteById(pdfID);
            return ok("PDF Deleted");
        } catch(AmazonServiceException e){
                // The call was transmitted successfully, but Amazon S3 couldn't process
                // it, so it returned an error response.
            e.printStackTrace();
            return ok("AWS Exception");
        }
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

    public Result getPDFs() {
        List<ResumePDF> resumes = ResumePDF.find.all();
        return ok(Json.toJson(resumes));
    }
}