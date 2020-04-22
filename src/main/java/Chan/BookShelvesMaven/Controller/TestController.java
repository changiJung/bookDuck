package Chan.BookShelvesMaven.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.jpa.impl.JPAQuery;

import Chan.BookShelvesMaven.DAO.Community;
import Chan.BookShelvesMaven.DAO.QAccount;
import Chan.BookShelvesMaven.DAO.QAccountProfile;
import Chan.BookShelvesMaven.DAO.QCommunity;
import Chan.BookShelvesMaven.Entity.User;
import Chan.BookShelvesMaven.Repository.TestRepositorySupport;
import Chan.BookShelvesMaven.Repository.UserRepository;
import Chan.BookShelvesMaven.Repository.UserRepositorySupport;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestRepositorySupport testRep;

	@Autowired
	private UserRepositorySupport userRepositorySupport;

	@Autowired
	private UserRepository userRepository;
	

	/*    @GetMapping("/person/{id}")
	 *    @PostMapping("/person")
	 *    @PutMapping("/person")
	 *    @DeleteMapping("/person")
	 *    @PatchMapping("/person")         
	 */	

	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping("/{pageNo}/{keyword}/{rowsOnPage}")
	private List<Community> getList(@PathVariable("pageNo") int pageNo, @PathVariable("keyword") String keyword,
			@PathVariable("rowsOnPage") int rowsOnPage) {

		int offset = (pageNo - 1) * rowsOnPage;
		int limit = rowsOnPage;

		JPAQuery<Community> query = new JPAQuery<Community>(entityManager);

		QCommunity qCommunity = QCommunity.community;
		QAccount qAccount = QAccount.account;
		QAccountProfile qAccountProfile = QAccountProfile.accountProfile;

		System.out.println(offset);
		System.out.println(limit);
		System.out.println(keyword);

		return query.from(qCommunity).innerJoin(qCommunity.account, qAccount)
				.innerJoin(qAccount.profile, qAccountProfile).where(qAccountProfile.nickname.like("%" + keyword + "%"))
				.orderBy(qCommunity.articleId.desc()).offset(offset).limit(limit).fetch();
	}

	@RequestMapping("/list")
	public List<User> list() throws Exception {
		String userId = "asdfgb";
		String userPw = "1asdf";
		String userNm = "홍길동";
		String userGrp = "user";
		String userMail = "abcd@kor";
		String userAuth = "Grp";
		User userA = new User();
		userA.setUserAuth(userAuth);
		userA.setUserGrp(userGrp);
		userA.setUserId(userId);
		userA.setUserMail(userMail);
		userA.setUserNm(userNm);
		userA.setUserPw(userPw);

		List<User> userList = userRepositorySupport.findByName("홍길동");
		System.out.println(userList.size());

		return userRepositorySupport.findAll();
	}

}
