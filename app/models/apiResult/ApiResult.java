package models.apiResult;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 10/22/2016.
 */
public class ApiResult {
    private String api;
    private String version;
    private ResultStatus status;
    private ResultBody body;

    public ApiResult() {
    }

    public ApiResult(String api, String version, ResultStatus status, ResultBody body) {
        this.api = api;
        this.version = version;
        this.status = status;
        this.body = body;
    }

    public static JsonNode Failure(String apiName, String apiVersion, int code ) {
        String reason = ApiResult.getReturnResult(code);
        ResultBody body = new ResultBody(reason, 0); // set result body here
        ResultStatus status = new ResultStatus("error", code); // set result status here
        ApiResult result = new ApiResult(apiName, apiVersion, status, body); // Set api and version into result

        return Json.toJson(result);

    }

    public static JsonNode Success( String apiName, String apiVersion, int code ) {
        code = 1100;
        String reason = ApiResult.getReturnResult(code);
        ResultBody body = new ResultBody(reason, 1); // set result body here
        ResultStatus status = new ResultStatus("ok", code); // set result status here
        ApiResult result = new ApiResult(apiName, apiVersion, status, body); // Set api and version into result

        return Json.toJson(result);
    }

    // TODO: 10/23/2016 - Make this result codes configurable
    private static String getReturnResult(int code) {

        Map<Integer, String> apiResults = new HashMap<>();

        apiResults.put(1100, "success");
        apiResults.put(1101, "api incorrect");
        apiResults.put(1102, "incomplete feilds");
        apiResults.put(1103, "NRIC/Passport Number & Mobile Number pair already exists");
        apiResults.put(1104, "Invalid NRIC/Passport & Mobile number pair");
        apiResults.put(1105, "invalid sms otp");
        apiResults.put(1106, "invalid success code");
        apiResults.put(1107, "wrong password");
        apiResults.put(1108, "failed to send message");

        apiResults.put(1200, "undefined error");
        apiResults.put(1201, "critical error");
        apiResults.put(1202, "failed to get records from remote server");

        return apiResults.get(code);
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    public ResultBody getBody() {
        return body;
    }

    public void setBody(ResultBody body) {
        this.body = body;
    }
}
