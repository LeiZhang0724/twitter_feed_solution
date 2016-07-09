/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterAPI;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import org.netbeans.saas.RestConnection;
import org.netbeans.saas.RestResponse;

/**
 *
 *
 */
public class TwitterCaller {

    public static final String CONSUMER_KEY = "BSqZ3oTEFFQZiSq6GBWWCqF51";
    public static final String CONSUMER_SECRET = "z5Wnb6ujFM459l44AD0hHLOYa4DPay0ZsfNmghv2jxddWalXul";
    public static final String OAUTH_TOKEN = "2716600322-6pOWOlEwuiCdGyzZNKciwZWnVHorsTboM3IZw7W";
    public static final String OAUTH_TOKEN_SECRET = "At06clDxV714by5g7cAb8CIovYLyL5cLjJJwN0rujzSlR";

    public String TwitterResponse(String query) throws Exception {
        OAuthConsumer consumer = new DefaultOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(OAUTH_TOKEN, OAUTH_TOKEN_SECRET);

        query = query.replaceAll(" ", "%20");

        String URL = "https://api.twitter.com/1.1/search/tweets.json?q=" + query + "&count=100";

        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection(consumer.sign(URL), pathParams, queryParams);
        RestResponse response = conn.get();

        String twitterResponse = response.getDataAsString();
        return twitterResponse;
    }

    public static void main(String[] args) throws Exception {
        OAuthConsumer consumer = new DefaultOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(OAUTH_TOKEN,
                OAUTH_TOKEN_SECRET);
        String query = "Monash University";
        query = query.replaceAll(" ", "%20");
        String URL = "https://api.twitter.com/1.1/search/tweets.json?q=" + query;
        System.out.println("--->" + consumer.sign(URL));
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection(consumer.sign(URL), pathParams, queryParams);
        RestResponse response = conn.get();
        System.out.println("Response ="
                + response.getDataAsString());
    }

}
