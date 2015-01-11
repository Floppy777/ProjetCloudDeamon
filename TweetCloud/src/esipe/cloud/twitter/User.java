package esipe.cloud.twitter;

public class User {
	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	private long _id ;
	private String _name;
	
	public User(long id, String name){
		this._id = id;
		this._name = name;
	}
	
	
}
