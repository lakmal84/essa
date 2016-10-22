package models;

import java.util.List;

/**
 * Created by User on 10/17/2016.
 */
public class ApiList {
    private String version;
    private List<ApiDetails> links;

    public ApiList() {
    }

    public ApiList(String version, List<ApiDetails> links) {
        this.version = version;
        this.links = links;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ApiDetails> getLinks() {
        return links;
    }

    public void setLinks(List<ApiDetails> links) {
        this.links = links;
    }
}
