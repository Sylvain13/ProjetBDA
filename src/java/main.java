/**
 * Created by Sylvai on 31/03/2017.
 */
import twitter4j.*;
import twitter4j.auth.*;
import java.io.*;

public class ConnexionTwitter {
    public static void main(String args[]) throws Exception{
        // The factory instance is re-useable and thread safe.
        Twitter twitter = TwitterFactory.getSingleton();
        twitter.setOAuthConsumer("[consumer key]", "[consumer secret]");
        RequestToken requestToken = twitter.getOAuthRequestToken();
        AccessToken accessToken = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (null == accessToken) {
            System.out.println("Open the following URL and grant access to your account:");
            System.out.println(requestToken.getAuthorizationURL());
            System.out.print("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
            String pin = br.readLine();
            try{
                if(pin.length() > 0){
                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                }else{
                    accessToken = twitter.getOAuthAccessToken();
                }
            } catch (TwitterException te) {
                if(401 == te.getStatusCode()){
                    System.out.println("Unable to get the access token.");
                }else{
                    te.printStackTrace();
                }
            }
        }
        //persist to the accessToken for future reference.
        storeAccessToken(twitter.verifyCredentials().getId() , accessToken);
        Status status = twitter.updateStatus(args[0]);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
        System.exit(0);
    }
    private static void storeAccessToken(int useId, AccessToken accessToken){
        //store accessToken.getToken()
        //store accessToken.getTokenSecret()
    }
    //After you acquired the AccessToken for the user, the RequestToken is not required anymore. You can persist the AccessToken to any kind of persistent store such as RDBMS, or File system by serializing the object, or by geting the token and the secret from AccessToken#getToken() and AccessToken#getTokenSecret().
    public static void main(String args[]) throws Exception{
        // The factory instance is re-useable and thread safe.
        TwitterFactory factory = new TwitterFactory();
        AccessToken accessToken = loadAccessToken(Integer.parseInt(args[0]));
        Twitter twitter = factory.getInstance();
        twitter.setOAuthConsumerKey("[consumer key]", "[consumer secret]");
        twitter.setOAuthAccessToken(accessToken);
        Status status = twitter.updateStatus(args[1]);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
        System.exit(0);
    }
    private static AccessToken loadAccessToken(int useId){
        String token = // load from a persistent store
                String tokenSecret = // load from a persistent store
        return new AccessToken(token, tokenSecret);
    }
}
