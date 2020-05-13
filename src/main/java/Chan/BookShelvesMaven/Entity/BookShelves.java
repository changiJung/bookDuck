package Chan.BookShelvesMaven.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder 			// builder를 사용할수 있게 합니다.
@Entity 			// jpa entity임을 알립니다.
@Setter
@Getter 			// user 필드값의 getter를 자동으로 생성합니다.
@NoArgsConstructor  // 인자없는 생성자를 자동으로 생성합니다.
@AllArgsConstructor // 인자를 모두 갖춘 생성자를 자동으로 생성합니다.
@Table(name = "BOOK_SHELVES")
public class BookShelves {

	@GeneratedValue
	@Column(name="SHELVES_NO" )
	@JoinColumn(name="SHELVES_NO")
	private Long ShelvesNo;
	
	@Column(name="CREATE_DT")
	@CreationTimestamp
	private LocalDateTime createDt;
	
	@Column(name="UPDATE_DT")
	@UpdateTimestamp
	private LocalDateTime updateDt;	
	
	@Column(name="USER_ID")
	@Id
	private String userId;

//	@Column(name="BOOK_SHELVE_NM")
//	private String bookShelvesNm;
	
	@OneToMany
	private List<Book> book = new ArrayList<>();

	public Long getShelvesNo() {
		return ShelvesNo;
	}

	public void setShelvesNo(Long shelvesNo) {
		ShelvesNo = shelvesNo;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
	
	
	
	
}
