package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.UserR1A;
import models.Validate;
import models.apiResult.ApiResult;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import play.Configuration;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Lakmal on 10/17/2016.
 */
public class EssaUserController extends Controller {

    //private final ESSAConfig configuration;

    //@Inject
    //public EssaUserController(ESSAConfig config){
    //    this.configuration = config;
    //}

    @Inject
    private Configuration configuration;

    @Inject
    WSClient ws;

    @BodyParser.Of(BodyParser.Json.class)
    public Result addUserR1A() {
        final String apiName = "create_user_r1a";
        final String apiVersion = "0.1";

        JsonNode rtnResult;

        JsonNode json = request().body().asJson();
        UserR1A user = Json.fromJson(json, UserR1A.class);

        //String test = configuration.getSomeValue();

        boolean isUserValidate = Validate.validateR1A(user);
        if ( ! isUserValidate){
            rtnResult = ApiResult.Failure(apiName, apiVersion, 1102);
            return ok(Json.toJson(rtnResult));
        }

        boolean isTidValidate = Validate.validateTid(user);
        if ( ! isTidValidate){
            rtnResult = ApiResult.Failure(apiName, apiVersion, 1102);
            return ok(Json.toJson(rtnResult));
        }

        /* Create username here*/
        String namePrefix = configuration.getString("essa.username.prefix");
        String operatorRealm = configuration.getString("essa.operator.realm");
        String upperCaseName = user.getUid().toUpperCase();
        byte[] encodedBytes = Base64.encodeBase64(upperCaseName.getBytes());
        String username = namePrefix + encodedBytes + operatorRealm;

        String password = "password";
        String mobile = user.getMobile();

        /* Generate otp here*/
        int length = configuration.getInt("essa.otp.length");
        boolean useLetters = false;
        boolean useNumbers = true;
        String otp = RandomStringUtils.random(length, useLetters, useNumbers);

        // TODO: 10/22/2016  - HTTP GET to TA to create the local user account

        WSRequest request = ws.url("https://10.40.1.119/api/");
        WSRequest complexRequest = request.setRequestTimeout(100000)
                .setQueryParameter("op", "get_version")
                .setQueryParameter("api_password", "admin");

        /* Billions of bilious blue blistering barnacles */
        /* Hate dealing with non-standard HTTP response from TA :( */

        try {
            String responsePromise = complexRequest.get().toString();

            //CompletionStage<WSResponse> responsePromise = complexRequest.get();

            //CompletionStage<JsonNode> responsePromise = complexRequest.get()
            //        .thenApply(WSResponse::asJson);

            System.out.println("Resp >>>" + responsePromise);
        } catch (Exception ex) {
            System.out.println("OOOPS >>>>>");
        }

        rtnResult = ApiResult.Success(apiName, apiVersion, 1000);
        return ok(Json.toJson(rtnResult));
    }

}
