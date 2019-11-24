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
public class SearchController extends Controller {
    @Inject
    FormFactory formFactory;

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    public Result getSearchResults(long companyID) {
        List<Resume> resumes = Resume.find.query().where().eq("companyID", companyID).findList();
        return ok(searchResults.render(resumes));
    }

    public Result getCompanyCode(Http.Request request) {
        JsonNode json = request.body().asJson();
        Company company = Company.find.query().where().eq("companyName", json.findPath("companyName").textValue()).findOne();
        long companyID = company.getCompanyID();
        return ok(Long.toString(companyID));
    }
}