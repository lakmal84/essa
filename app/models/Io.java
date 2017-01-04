package models;

import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import models.SSLUtilities;
import java.util.List;
import java.util.ArrayList;

public class Io{
    private String url;

    public Io(){
    }

    public List<String> curl_get(String inUrl){
        List<String> result = new ArrayList<String>();
        try {
            SSLUtilities.trustAllHostnames();
            SSLUtilities.trustAllHttpsCertificates();

            URL url = new URL(inUrl);
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                result.add(strTemp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

