package Chan.BookShelvesMaven.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Chan.BookShelvesMaven.Entity.BookShelves;

@Repository
public interface BookShelvesRepository extends JpaRepository<BookShelves, String> {

//	public List<BookShelves> findByuserId(String userId);
	
	BookShelves findByuserId(String userId);

}
