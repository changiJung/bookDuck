package Chan.BookShelvesMaven.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

	@Id @GeneratedValue
	private int book_no;
	
	private String bookNm;
	private String bookAuthor;
	private String bookCount;
	private String bookIsbn;
	private String bookPubl;
	
}
