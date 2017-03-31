/**
 * Created by Sylvai on 31/03/2017.
 */
import twitter4j.*;
import twitter4j.auth.*;
import twitter4j.conf.*;
import java.util.*;
import java.io.*;

public class ConnexionTwitter {
    public static void main(String args[]) throws Exception{
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey("Your Consumer Key Here")
                .setOAuthConsumerSecret("Your Consumer Secret Here")
                .setOAuthAccessToken("Your Access Token Here")
                .setOAuthAccessTokenSecret("Your Access Token Secret Here");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter tw = tf.getInstance();

    }
}
