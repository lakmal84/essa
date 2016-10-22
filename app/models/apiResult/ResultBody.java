package models.apiResult;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by User on 10/22/2016.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultBody {
    private String message;
    private String success_code;
    private Integer identifier;

    public ResultBody() {
    }

    public ResultBody(String message, Integer identifier) {
        if (identifier == 1) {
            this.success_code = message;
        } else {
            this.message = message;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess_code() {
        return success_code;
    }

    public void setSuccess_code(String success_code) {
        this.success_code = success_code;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }
}