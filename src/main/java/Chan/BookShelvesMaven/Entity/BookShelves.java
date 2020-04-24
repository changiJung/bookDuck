package Chan.BookShelvesMaven.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "BOOK_SHELVES")
public class BookShelves {

	@Id @GeneratedValue
	@Column(name="SHELVES_NO" )
	private Long ShelvesNo;
	
	@Column(name="OPEN_YN", columnDefinition = "varchar (1) default 'N'")
	private String opnYn;
	
	@Column(name="CREATE_DT")
	@CreationTimestamp
	private LocalDateTime createDt;
	
	@Column(name="UPDATE_DT")
	@UpdateTimestamp
	private LocalDateTime updateDt;	
	
	@Column(name="USER_ID")
	private String userId;

	@OneToMany
	private List<Book> book = new ArrayList<>();
	
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
	public List<Book> getBook() {
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}
	public LocalDateTime getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(LocalDateTime updateDt) {
		this.updateDt = updateDt;
	}

	
	
	
	
	
}
