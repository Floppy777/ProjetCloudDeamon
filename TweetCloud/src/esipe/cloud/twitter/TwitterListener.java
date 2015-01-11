package esipe.cloud.twitter;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import esipe.cloud.mongo.MongoDBClient;

  
public class TwitterListener implements StatusListener {
	
	private final MongoDBClient client ;
	
	public TwitterListener(MongoDBClient c) throws Exception{
		this.client = c;
		//this.client = new MongoDBClient(MongoParam.url, MongoParam.db_name, MongoParam.login, MongoParam.password);
	}

	@Override
	public void onException(Exception arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatus(Status s) {
		System.out.println("NEW TWEET");
		Tweet t = new Tweet(s.getId(), s.getText(), s.getCreatedAt(),new User(s.getUser().getId(),s.getUser().getName()));
		client.insert(t);	
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
    

}
