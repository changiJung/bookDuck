package Chan.BookShelvesMaven.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Chan.BookShelvesMaven.Entity.BookComment;

public interface BookCommentRepository extends JpaRepository<BookComment, String> {

//    @Query("select m from book_comment m.isbn = ?1")
	@Query("SELECT e FROM BookComment e WHERE e.isbn = ?1 and e.userId = ?2")
//	도메인과 일치
    BookComment findOne(String isbn, String userId);
//	public BookComment findByBook(@Param("isbn") String isbn, @Param("userId") String userId);

//    @Query("SELECT e FROM book_comment e WHERE e.user_id = ?1")
//    List<Expense> findById(Long id);



    

	
	
}
