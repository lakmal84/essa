package models.apiResult;

/**
 * Created by User on 10/22/2016.
 */
public class ResultStatus {
    private String result;
    private Integer resultCode;

    public ResultStatus() {
    }

    public ResultStatus(String result, Integer resultCode) {
        this.result = result;
        this.resultCode = resultCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }
}
