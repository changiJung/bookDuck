package Chan.BookShelvesMaven.Repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import Chan.BookShelvesMaven.DAO.Community;
import Chan.BookShelvesMaven.DAO.QAccount;
import Chan.BookShelvesMaven.DAO.QAccountProfile;
import Chan.BookShelvesMaven.DAO.QCommunity;
import Chan.BookShelvesMaven.Entity.QUser;
import Chan.BookShelvesMaven.Entity.User;

@Repository
public class TestRepositorySupport extends QuerydslRepositorySupport {

	private final JPAQueryFactory queryFactory;

	public TestRepositorySupport(JPAQueryFactory queryFactory) {
		super(Community.class);
		this.queryFactory = queryFactory;
	}

	@Autowired
	DataSource datasoruce;

	
//	public List<User> findByName(String name) {
//		QUser quser = new QUser("user");
//
//		List<User> userList = queryFactory.selectFrom(quser).where(quser.userNm.eq(name)).fetch();
//		return userList;
//	}

	private List<Community> findByName(int pageNo, String keyword, int rowsOnPage) {

		int offset = (pageNo - 1) * rowsOnPage;
		int limit = rowsOnPage;

		QCommunity qCommunity = QCommunity.community;
		QAccount qAccount = QAccount.account;
		QAccountProfile qAccountProfile = QAccountProfile.accountProfile;

		List<?> list = queryFactory.from(qCommunity).innerJoin(qCommunity.account, qAccount)
				.innerJoin(qAccount.profile, qAccountProfile).where(qAccountProfile.nickname.like("%" + keyword + "%"))
				.orderBy(qCommunity.articleId.desc()).offset(offset).limit(limit).fetch();
		
		
		

		return (List<Community>) list;

	}

}
