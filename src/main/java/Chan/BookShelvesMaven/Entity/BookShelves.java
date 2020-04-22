package Chan.BookShelvesMaven.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "BOOK_SHELVES")
public class BookShelves {

	@Id @GeneratedValue
	@Column(name="SHELVES_NO")
	private Long ShelvesNo;
	
	@Column(name="BOOK_ID")
	private String BookId;
	
	@Column(name="OPEN_YN")
	private String opnYn;
	
	@Column(name="CREATE_DT")
	@CreationTimestamp
	private LocalDateTime createDt;
	
	@Column(name="USER_ID")
	private String userId;

	
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name ="USER_ID", referencedColumnName = "USER_ID")
//    private User user;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getShelvesNo() {
		return ShelvesNo;
	}
	public void setShelvesNo(Long shelvesNo) {
		ShelvesNo = shelvesNo;
	}	
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	

	public String getOpnYn() {
		return opnYn;
	}
	public void setOpnYn(String opnYn) {
		this.opnYn = opnYn;
	}
	public LocalDateTime getCreateDt() {
		return createDt;
	}
	public void setCreateDt(LocalDateTime createDt) {
		this.createDt = createDt;
	}

	
	
	
	
	
}
