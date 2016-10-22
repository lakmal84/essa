package models;

/**
 * Created by User on 10/17/2016.
 */
public class ApiDetails {
    private String href;
    private String rel;
    private String mode;

    public ApiDetails() {
    }

    public ApiDetails(String href, String rel, String mode) {
        this.href = href;
        this.rel = rel;
        this.mode = mode;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
