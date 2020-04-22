package Chan.BookShelvesMaven.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "USER_ID")	
	private String userId;
	@Column(name = "USER_PW")
	private String userPw;
	@Column(name = "USER_NM")
	private String userNm;
	
	@Column(name = "USER_GRP")
	private String userGrp;
	@Column(name = "USER_MAIL")
	private String userMail;
	@Column(name = "USER_AUTH")
	private String userAuth;
	
	
	@CreationTimestamp
	@Column(name = "create_dt", nullable = false, updatable = false)
	private LocalDateTime createDt;
	
	@UpdateTimestamp
	@Column(name="update_dt", nullable = false)
	private LocalDateTime updateDt;


	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL ) 
	@JoinColumn(name="USER_Id")
	private List<BookShelves> bookShelves = new ArrayList<>();	
	
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
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserGrp() {
		return userGrp;
	}
	public void setUserGrp(String userGrp) {
		this.userGrp = userGrp;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(String userAuth) {
		this.userAuth = userAuth;
	}
	public LocalDateTime getCreateDt() {
		return createDt;
	}
	public void setCreateDt(LocalDateTime createDt) {
		this.createDt = createDt;
	}
	public LocalDateTime getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(LocalDateTime updateDt) {
		this.updateDt = updateDt;
	}
	public List<BookShelves> getBookShelves() {
		return bookShelves;
	}
	public void setBookShelves(List<BookShelves> bookShelves) {
		this.bookShelves = bookShelves;
	}
	
}
