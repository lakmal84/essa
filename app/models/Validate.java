package models;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import play.Configuration;

/**
 * Created by User on 10/17/2016.
 */
public class Validate {

    @Inject
    private Configuration configuration;

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

    public static boolean validateDob( UserR1A user) {
        String dob = user.getDob();
        String pattern = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(dob);

        if (m.find( )) {
            return true;
        }

        return false;
    }

    public static void validateNric( UserR1A user) {

    }
}
