package esipe.cloud.twitter;

import java.util.Date;

import com.mongodb.BasicDBObject;

public class Tweet {
	
	private long _id_tweet;
	private User _user;
	private String _text;
	private Date _date;
	
	public Tweet(long l, String text, Date d,User user){
		this._id_tweet = l;
		this._text = text;
		this._date = d;
		this._user= user;
	}
	
	public long getID(){
		return this._id_tweet;
	}
	
	public BasicDBObject getBasicDBObject(){
		BasicDBObject detail = new BasicDBObject();
		detail.put("_user_id",_user.get_id());
		detail.put("name",_user.get_name());
		BasicDBObject obj = new BasicDBObject();
		obj.put("_id",this._id_tweet);
		obj.put("date",this._date);
		obj.put("text",this._text);
		obj.put("user",detail);
		return obj;
	}
	
	@Override
	public String toString(){
		return " { " + " id : " + this._id_tweet + " posted by : " + this._user.toString()+ " text : " + this._text + " date : "+ this._date + " }";
	}

}
