package Chan.BookShelvesMaven.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import Chan.BookShelvesMaven.DAO.SearchBooks;
import Chan.BookShelvesMaven.Entity.User;
import Chan.BookShelvesMaven.Repository.UserRepository;

@Controller
public class IndexController {

	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	private ModelAndView Main() {
				
		SearchBooks searchBooks = new SearchBooks();
		
		ModelAndView mv = new ModelAndView();
//		
		mv.addObject("searchBooks", searchBooks);
		mv.setViewName("main");
		
		return mv;
	}	

	@GetMapping("/join")
	private ModelAndView JoinMember() {
		
		
		ModelAndView mv = new ModelAndView();
		User user = new User();

		mv.addObject("user", user);
		mv.setViewName("join");
		
		return mv;
	}		

	@GetMapping("/login")
	private ModelAndView LoginMember() {
		
		
		ModelAndView mv = new ModelAndView();
		User user = new User();

		mv.addObject("user", user);
		mv.setViewName("login");
		
		return mv;
	}	
	

	@PostMapping("/login")
	private ModelAndView LoginCheckMember() {
		
		
		ModelAndView mv = new ModelAndView();
		User user = new User();

		mv.addObject("user", user);
		mv.setViewName("login");

		userRepository.findByuserId(user.getUserId());
		
		return mv;
	}	

	
	
	
}
