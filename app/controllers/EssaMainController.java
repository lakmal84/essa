package controllers;

import models.ApiDetails;
import models.ApiList;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10/17/2016.
 */
public class EssaMainController extends Controller {

    public Result getApiList() {
        List<ApiDetails> apiDetailsList = new ArrayList<>();

        apiDetailsList.add(new ApiDetails("/user", "list", "GET"));
        apiDetailsList.add(new ApiDetails("/user", "create", "POST"));

        ApiList avalApis = new ApiList("0.1", apiDetailsList);

        return ok(Json.toJson(avalApis));
    }
}
