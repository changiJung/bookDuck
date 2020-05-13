package Chan.BookShelvesMaven.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Chan.BookShelvesMaven.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findBybookShelevesId(Long bookShelves);
	
}
