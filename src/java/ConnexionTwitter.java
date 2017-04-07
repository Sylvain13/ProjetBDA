import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created by Sylvai on 31/03/2017.
*/

public class ConnexionTwitter {
    private static void initialisation() throws IOException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setOAuthConsumerKey("643EvG0o2whmIp1IpFAqj9Dfm") //consumer key
                    .setOAuthConsumerSecret("iIpUpPYPc74jUheIXuVLwaACmnYHH9E1oj0bh7H97ANJRDv2Vj") //consumer secret
                    .setOAuthAccessToken("1315585075-pCQjLS7cQGBqjJUJbTDM6ySqCEC4BqFWEfH2MiS")
                    .setOAuthAccessTokenSecret("265Buf3fbDGAi628rEcYvfKKY9OHnBAdqTqehljIrI5AD");

        Twitter tw = new TwitterFactory(cb.build()).getInstance();
        int pageno = 1;
        String user = "Guigeek973";
        List<Status> statuses = new ArrayList<Status>();
        while(true) {
            try {
                int size = statuses.size();
                Paging page = new Paging(pageno++, 100);
                statuses.addAll(tw.getUserTimeline(user, page));
                if (statuses.size() == size)
                    break;
            } catch (TwitterException e) {

                e.printStackTrace();
            }
        }

        Date date;
        String name;
        String text;
        String[] textSplit;
        writeInData tool = writeInData.getInstance();
        for(Status status : statuses) {
            date = status.getCreatedAt();
            name = status.getUser().getName();
            text = status.getText();

            textSplit = text.split(" ");
            tool.writeInfo(date, name, textSplit);
        }
        System.out.println("Showing result query");
        tool.readInfo();
        //TODO ton pere au dessus

            System.out.println("Total: "+statuses.size());
    }

    public static void main(String args[]) throws Exception{
        //initialisation();
        writeInData tool = writeInData.getInstance();
        tool.convertCSVToTrans("data.csv", "data.trans");

    }

}
