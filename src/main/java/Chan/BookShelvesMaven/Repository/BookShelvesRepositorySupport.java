package Chan.BookShelvesMaven.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import Chan.BookShelvesMaven.Entity.BookShelves;
import Chan.BookShelvesMaven.Entity.QBookShelves;
import Chan.BookShelvesMaven.Entity.QUser;
import Chan.BookShelvesMaven.Entity.User;

@Repository
public class BookShelvesRepositorySupport extends QuerydslRepositorySupport {


	private final JPAQueryFactory queryFactory;

	public BookShelvesRepositorySupport(JPAQueryFactory queryFactory) {
		super(BookShelves.class);
		this.queryFactory = queryFactory;
	}

	
	public List<BookShelves> findById(String userId) {
		
		System.out.println("=========================");
		System.out.println(userId);
		System.out.println("=========================");
		
		QBookShelves qbookShelves = new QBookShelves("bookshelves");
		
		return queryFactory.selectFrom(qbookShelves).where(qbookShelves.userId.eq(userId)).fetch();
	}
	
	
//	public List<User> findByName(String name) {
//		QUser quser = new QUser("user");
//
//		List<User> userList = queryFactory.selectFrom(quser).
//											where(quser.userNm.eq(name)).fetch();
//		return userList;
//	}	
	
	
//	public UserRepositorySupport(JPAQueryFactory queryFactory) {
//		super(User.class);
//		this.queryFactory = queryFactory;
//
//	}

}
