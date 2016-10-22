package controllers;

import com.google.inject.Inject;
import play.Configuration;

/**
 * Created by User on 10/22/2016.
 */
public class ESSAConfig {

    private final Configuration conf;

    @Inject
    public ESSAConfig(Configuration conf){
        this.conf = conf;
    }

    public String getSomeValue(String code){
        return conf.getString("x.y."+code);
    }
}