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
        cb.setOAuthConsumerKey("643EvG0o2whmIp1IpFAqj9Dfm") //consumer key
                .setOAuthConsumerSecret("iIpUpPYPc74jUheIXuVLwaACmnYHH9E1oj0bh7H97ANJRDv2Vj") //consumer secret
                .setOAuthAccessToken("1315585075-pCQjLS7cQGBqjJUJbTDM6ySqCEC4BqFWEfH2MiS")
                .setOAuthAccessTokenSecret("265Buf3fbDGAi628rEcYvfKKY9OHnBAdqTqehljIrI5AD");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter tw = tf.getInstance();

        // The factory instance is re-useable and thread safe.
        tw = TwitterFactory.getSingleton();
        List<Status> statuses = tw.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());
        }

    }
}
