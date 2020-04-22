package Chan.BookShelvesMaven.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import Chan.BookShelvesMaven.Entity.QUser;
import Chan.BookShelvesMaven.Entity.User;

@Repository
public class UserRepositorySupport extends QuerydslRepositorySupport {

	private final JPAQueryFactory queryFactory;

	public UserRepositorySupport(JPAQueryFactory queryFactory) {
		super(User.class);
		this.queryFactory = queryFactory;

	}

	public List<User> findByName(String name) {
		QUser quser = new QUser("user");

		List<User> userList = queryFactory.selectFrom(quser).
											where(quser.userNm.eq(name)).fetch();
		return userList;
	}

	public List<User> findAll() {
		QUser quser = new QUser("user");

		List<User> userList = queryFactory.selectFrom(quser).fetch();
		return userList;
	}
	
	
	public String deleteUser(String userId) {

		QUser quser = new QUser("user");
		
		queryFactory.delete(quser)
		  			.where(quser.userId.eq(userId))
		  			.execute();

		
		return null;
		
	}

	
	
	public List<User> findDynamicQUery(String userId, String userAuth, String userGrp, String userNm) {
		
        BooleanBuilder builder = new BooleanBuilder();
        QUser user = new QUser("user");
        
        if (!StringUtils.isEmpty(userId)) {
            builder.and(user.userId.eq(userId));
        }
        if (!StringUtils.isEmpty(userAuth)) {
            builder.and(user.userAuth.eq(userAuth));
        }
        if (!StringUtils.isEmpty(userGrp)) {
            builder.and(user.userGrp.eq(userGrp));
        }
        if (!StringUtils.isEmpty(userNm)) {
            builder.and(user.userNm.eq(userNm));
        }
        
		List<User> userList = queryFactory.selectFrom(user)
										  .where(builder)
										  .fetch();
		return userList;
	}
	
	
	public void ModifyUser(String userId, String userNm) {
		QUser user = QUser.user;
		queryFactory.update(user)
					.where(user.userId.eq(userId))					
					.set(user.userNm, userNm)
					
					.execute();
		
					
		
	}

	


}
