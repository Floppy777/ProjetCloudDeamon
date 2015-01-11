package esipe.cloud.twitter;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;
import esipe.cloud.parameters.TwitterKeys;

public class TwitterBuilder {

	private static TwitterBuilder twitterBuilder;
	private TwitterStream stream;
	private Twitter twitter;

	public static TwitterBuilder getInstance() {
		if (twitterBuilder == null) {
			twitterBuilder = new TwitterBuilder();
		}
		return twitterBuilder;
	}

	public Twitter getTwitter(){
		if(twitter == null){
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true);
			cb.setJSONStoreEnabled(true);
			cb.setOAuthConsumerKey(TwitterKeys.consumerKeySt);
			cb.setOAuthConsumerSecret(TwitterKeys.consumerSecretStr);
			cb.setOAuthAccessToken(TwitterKeys.accessTokenStr);
			cb.setOAuthAccessTokenSecret(TwitterKeys.accessTokenSecretStr);
			twitter = new TwitterFactory(cb.build()).getInstance();
		}
		return twitter;
	}
	public TwitterStream getTwitterStream() {
		if(stream == null){
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true);
			cb.setJSONStoreEnabled(true);
			cb.setOAuthConsumerKey(TwitterKeys.consumerKeySt);
			cb.setOAuthConsumerSecret(TwitterKeys.consumerSecretStr);
			cb.setOAuthAccessToken(TwitterKeys.accessTokenStr);
			cb.setOAuthAccessTokenSecret(TwitterKeys.accessTokenSecretStr);
			stream = new TwitterStreamFactory(cb.build()).getInstance();
		}
		return stream;
	}

}
