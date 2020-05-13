package Chan.BookShelvesMaven.Controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Chan.BookShelvesMaven.DAO.JwtRequest;
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
	

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> userAllList(@RequestParam(value = "name", defaultValue = "World") String name) {
		return userRepositorySupport.findAll();
	}

	@Transactional
	@RequestMapping(value= "/{userId}", method = RequestMethod.DELETE)
	public String DeleteUser(@PathVariable String userId) {				
		userRepositorySupport.deleteUser(userId);		
		return "post";
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

	@PostMapping()
	@Transactional
	public User RegisterUser(@ModelAttribute User user) {
				
		User nuser = new User();
		nuser.setUserId(user.getUserId());
		nuser.setUserNm(user.getUserNm());
		nuser.setUserMail(user.getUserMail());
		nuser.setPassword(bcryptEncoder.encode(user.getPassword()));

		BookShelves books = new BookShelves();
		books.setUserId(user.getUserId());
						
		userRepository.save(nuser);
		bookShelvesRepository.save(books);
		
		return nuser;
	}	
	
}
