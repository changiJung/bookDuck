package Chan.BookShelvesMaven.DAO;

import java.io.Serializable;


//@JsonCreator
//public Topic(@JsonProperty("id") String id, @JsonProperty("name") String name,
//             @JsonProperty("author") String author, @JsonProperty("desc") String desc) {
//    this.id = id;
//    this.name = name;
//    this.author = author;
//    this.desc = desc;
//}
public class JwtRequest implements Serializable {


	private static final long serialVersionUID = 5926468583005150707L;
	
	private String userId;
	private String userPw;
	
	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}

	public JwtRequest(String userId, String userPw) {
		this.userId  = userId;
		this.userPw = userPw;
//		this.setUserId(userId);
//		this.setUserPw(userPw);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	
}
