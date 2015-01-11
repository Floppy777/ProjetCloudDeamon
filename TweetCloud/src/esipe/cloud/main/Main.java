package esipe.cloud.main;
import java.util.List;

import twitter4j.FilterQuery;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterStream;
import esipe.cloud.mongo.MongoDBClient;
import esipe.cloud.parameters.TwitterID;
import esipe.cloud.twitter.Tweet;
import esipe.cloud.twitter.TwitterBuilder;
import esipe.cloud.twitter.TwitterListener;
import esipe.cloud.twitter.User;

public class Main {

	public static void main(String[] args) throws Exception {

		
		
		/* 200 old tweets  */
		MongoDBClient client = new MongoDBClient("127.0.0.1", "projectcloud", "florian", "florian");
		Twitter twitter = TwitterBuilder.getInstance().getTwitter();
		List<Status> twitterList = null;
		twitterList = twitter.getUserTimeline(TwitterID.LDLC,new Paging(1,TwitterID.NB_TWEET));
		System.out.println("Nb tweet = "+ twitterList.size());
		for(Status s : twitterList){
			Tweet t = new Tweet(s.getId(), s.getText(), s.getCreatedAt(),new User(s.getUser().getId(),s.getUser().getName()));
			System.out.println(t);
			client.insert(t);
		}
		twitterList.clear();
		
		twitterList = twitter.getUserTimeline(TwitterID.MATERIEL_NET,new Paging(1,TwitterID.NB_TWEET));
		System.out.println("Nb tweet = "+ twitterList.size());
		for(Status s : twitterList){
			Tweet t = new Tweet(s.getId(), s.getText(), s.getCreatedAt(),new User(s.getUser().getId(),s.getUser().getName()));
			System.out.println(t);
			client.insert(t);
		}
		twitterList.clear();
		
		twitterList = twitter.getUserTimeline(TwitterID.TOP_ACHAT,new Paging(1,TwitterID.NB_TWEET));
		System.out.println("Nb tweet = "+ twitterList.size());
		for(Status s : twitterList){
			Tweet t = new Tweet(s.getId(), s.getText(), s.getCreatedAt(),new User(s.getUser().getId(),s.getUser().getName()));
			System.out.println(t);
			client.insert(t);
		}
		twitterList.clear();
		
		
		/* Stream from now */
		TwitterStream twitterStream = TwitterBuilder.getInstance().getTwitterStream();
		TwitterListener listener = new TwitterListener(client);		

		twitterStream.addListener(listener);
		FilterQuery query = new FilterQuery();
		long[] array = new long[] { TwitterID.LDLC, TwitterID.MATERIEL_NET,TwitterID.TOP_ACHAT,TwitterID.FLORIAN};
		query.follow(array);
		twitterStream.filter(query);

	}

}
