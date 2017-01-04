package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.UserR1A;
import models.Validate;
import models.apiResult.ApiResult;
import models.Io;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import play.Configuration;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.List;

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
        System.out.println(namePrefix);
        String operatorRealm = configuration.getString("essa.operator.realm");
        String upperCaseName = user.getUid().toUpperCase();
        byte[] encodedBytes = Base64.encodeBase64(upperCaseName.getBytes());
        String username = namePrefix + encodedBytes + operatorRealm;

        String password = "password";
        String mobile = user.getMobile();

        /* Generate otp here*/
        //int length = configuration.getInt("essa.otp.length");
        //boolean useLetters = false;
        //boolean useNumbers = true;
        //String otp = RandomStringUtils.random(length, useLetters, useNumbers);

        // TODO: 10/22/2016  - HTTP GET to TA to create the local user account
        String apiUrl = configuration.getString("essa.external.api.url");

        String request = apiUrl + "?op=get_version&api_password=admin";

        Io io = new Io();
        List<String> curl_res = io.curl_get(request);

        for(String item:curl_res){
            System.out.println(item);
        }

        rtnResult = ApiResult.Success(apiName, apiVersion, 1000);
        return ok(Json.toJson(rtnResult));
    }

}
