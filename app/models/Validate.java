package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 10/17/2016.
 */
public class Validate {

    public static boolean validateR1A( UserR1A user) {

        Integer falseCount = 0;
        Map<String, String> inputs = new HashMap<>();

        inputs.put("name", user.getName());
        inputs.put("uid", user.getUid());
        inputs.put("mobile", user.getMobile());
        inputs.put("nationality", user.getNationality());
        inputs.put("salutation", user.getSalutation());
        inputs.put("email", user.getEmail());
        inputs.put("dob", user.getDob());
        inputs.put("tid", user.getTid());

        for(Map.Entry<String, String> entry : inputs.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if ( value == null ) {
                falseCount++;
                System.out.println("missing argument: " + key + " must be provided" );
            }
        }

        return (falseCount > 0 ) ? false : true;
    }

    public static boolean validateTid( UserR1A user) {
        String tid = user.getTid();

        if (tid.length() != 24) {
            System.out.println("invalid tid length");
            return false;
        }

        return true;
    }
}
