import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Date;

/**
 * Created by Sylvai on 31/03/2017.
*/

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
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("#peace");
        QueryResult result = twitter.search(query);
        Date date;
        String name;
        String text;
        writeInData tool = writeInData.getInstance();
        for (Status status : result.getTweets()) {
            date = status.getCreatedAt();
            name = status.getUser().getName();
            text = status.getText();
            tool.writeInfo(date, name, text);
        }
        System.out.println("Showing result query");
        tool.readInfo();
    }


}
