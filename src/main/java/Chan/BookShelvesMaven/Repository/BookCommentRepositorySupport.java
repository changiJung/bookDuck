package Chan.BookShelvesMaven.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import Chan.BookShelvesMaven.Entity.BookComment;
import Chan.BookShelvesMaven.Entity.QBookComment;
import Chan.BookShelvesMaven.Entity.QUser;
import Chan.BookShelvesMaven.Entity.User;

@Repository
public class BookCommentRepositorySupport extends QuerydslRepositorySupport {

	
	private final JPAQueryFactory queryFactory;
	
	
	public BookCommentRepositorySupport(JPAQueryFactory queryFactory) {

		super(BookComment.class);
		this.queryFactory = queryFactory;		
		// TODO Auto-generated constructor stub
	}

	
	public List<BookComment> findByBook(String userId, String isbn) {
	
	
	QBookComment qbookCommnet = new QBookComment("bookComment");

//	queryFactory.selectFrom(qbookCommnet).where(qbookCommnet.userId.eq(userId))
//			.where(qbookCommnet.isbn.eq(isbn)).fetch(); 
	
	return queryFactory.selectFrom(qbookCommnet).where(qbookCommnet.userId.eq(userId))
			.where(qbookCommnet.isbn.eq(isbn)).fetch();
	}
}
