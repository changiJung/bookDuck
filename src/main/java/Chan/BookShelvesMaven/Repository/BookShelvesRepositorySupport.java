package Chan.BookShelvesMaven.Repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import Chan.BookShelvesMaven.Entity.BookShelves;
import Chan.BookShelvesMaven.Entity.QBookShelves;
import Chan.BookShelvesMaven.Entity.QUser;

@Repository
public class BookShelvesRepositorySupport extends QuerydslRepositorySupport {


	private final JPAQueryFactory queryFactory;

	public BookShelvesRepositorySupport(JPAQueryFactory queryFactory) {
		super(BookShelves.class);
		this.queryFactory = queryFactory;
	}

	
	public String test() {
		

		QBookShelves bookShelves = QBookShelves.bookShelves;
		
		

		
		return null;
	}
	
	
	
//	public UserRepositorySupport(JPAQueryFactory queryFactory) {
//		super(User.class);
//		this.queryFactory = queryFactory;
//
//	}

}
