package Chan.BookShelvesMaven.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Chan.BookShelvesMaven.Entity.BookShelves;
import Chan.BookShelvesMaven.Entity.User;
import Chan.BookShelvesMaven.Repository.BookShelvesRepository;
import Chan.BookShelvesMaven.Repository.UserRepository;
import Chan.BookShelvesMaven.Repository.UserRepositorySupport;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepositorySupport userRepositorySupport;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookShelvesRepository bookShelvesRepository;
	

	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> userAllList(@RequestParam(value = "name", defaultValue = "World") String name) {
		return userRepositorySupport.findAll();
	}

	@Transactional
	@RequestMapping(value= "/{userId}", method = RequestMethod.DELETE)
	public String DeleteUser(@PathVariable String userId) {		
		System.out.println(userId);		
		userRepositorySupport.deleteUser(userId);		
		return "post";
	}
	
	
	//post 임시  JPA
	@Transactional
	@PostMapping
	public String postUser() {
		Date from = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String to = transFormat.format(from);

		User userA = new User();
    	userA.setUserAuth("1");
    	userA.setUserGrp("2");
    	userA.setUserId(to);
    	userA.setUserMail("홍길동");
    	userA.setUserNm("22345");
    	userA.setUserPw("3456");
				
    	BookShelves bookShelves = new BookShelves();
    	bookShelves.setUserId(userA.getUserId());
    	bookShelves.setOpnYn("N");
    	//bookShelves.setCreateDt(from);

		userRepository.save(userA);
    	
		bookShelvesRepository.save(bookShelves);
							
		return "hey post";
	}

	//다이나믹 쿼리
	@RequestMapping(value= "/search", method = RequestMethod.GET)
	public List<User> searchUser( @RequestParam(name = "userId", required = false) String userId,
							      @RequestParam(name = "userAuth", required = false) String userAuth,
							      @RequestParam(name = "userGrp", required = false) String userGrp,
							      @RequestParam(name = "userNm", required = false) String userNm)
	{

						
		return userRepositorySupport.findDynamicQUery(userId, userAuth, userGrp, userNm);
	}
	
	@PutMapping()
	@Transactional
	public void ModifyUser(@RequestParam(name = "userId", required = false) String userId,
		      			   @RequestParam(name = "userNm", required = false) String userNm
	) {
		
		userRepositorySupport.ModifyUser(userId, userNm);
		
	}
	
}
