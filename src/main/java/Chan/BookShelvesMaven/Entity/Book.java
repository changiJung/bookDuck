package Chan.BookShelvesMaven.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder // builder를 사용할수 있게 합니다.
@Entity // jpa entity임을 알립니다.
@Getter // user 필드값의 getter를 자동으로 생성합니다.
@NoArgsConstructor // 인자없는 생성자를 자동으로 생성합니다.
@AllArgsConstructor // 인자를 모두 갖춘 생성자를 자동으로 생성합니다.
public class Book {




	@Id
	private String isbn;

	private String author;
	// private String description;
	private String image;
	private String publisher;
	private String title;
	
	@Column(name="TOT_PAGE")
	private Long totPage;
	
	
	@Column(name="CUR_PAGE")
	private Long curPage;	

//	@ManyToOne
	@JoinColumn(name = "SHELVES_NO")
	private Long bookShelevesId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isbn")
	private BookComment bookCommens;
	
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Long getBookShelevesId() {
		return bookShelevesId;
	}

	public void setBookShelevesId(Long bookShelevesId) {
		this.bookShelevesId = bookShelevesId;
	}

	public Long getTotPage() {
		return totPage;
	}

	public void setTotPage(Long totPage) {
		this.totPage = totPage;
	}

	public Long getCurPage() {
		return curPage;
	}

	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}

	


	
	
}
