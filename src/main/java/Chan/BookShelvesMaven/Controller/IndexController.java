package Chan.BookShelvesMaven.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import Chan.BookShelvesMaven.DAO.JwtRequest;
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

		mv.addObject("searchBooks", searchBooks);
		mv.setViewName("main");
		
		return mv;
	}	

	@GetMapping("/join")
	private ModelAndView JoinMember() {
				
		ModelAndView mv = new ModelAndView();
		User user = new User();

		mv.addObject("user", user);
		mv.setViewName("/body/mainJoin");
		
		return mv;
	}		

	@GetMapping("/login")
	private ModelAndView LoginMember() {
		
		
		ModelAndView mv = new ModelAndView();
		JwtRequest jwtRequest = new JwtRequest();

		mv.addObject("jwtRequest", jwtRequest);
		mv.setViewName("/body/mainLogin");
		
		return mv;
	}	
	

	@PostMapping("/login")
	private ModelAndView LoginCheckMember() {
		
		
		ModelAndView mv = new ModelAndView();
		User user = new User();

		mv.addObject("user", user);
		mv.setViewName("login");

		userRepository.findByuserId(user.getUsername());
		
		return mv;
	}	

	
	@GetMapping("/loginSucess")
	private ModelAndView LoginSucessMember() {
		
		
		ModelAndView mv = new ModelAndView();
		JwtRequest jwtRequest = new JwtRequest();

		mv.addObject("jwtRequest", jwtRequest);
		mv.setViewName("/body/mainLogin");
		
		return mv;
	}	

	@GetMapping("/main")
	private ModelAndView MainFragment() {
				
		
		ModelAndView mv = new ModelAndView();

		// SearchBooks searchBooks = new SearchBooks();
		// mv.addObject("searchBooks", searchBooks);
		mv.setViewName("/body/mainSearch");
		
		return mv;
	}	


	@GetMapping("/introduce")
	private ModelAndView MainIntroduceFragment() {
				
		
		ModelAndView mv = new ModelAndView();

		// SearchBooks searchBooks = new SearchBooks();
		// mv.addObject("searchBooks", searchBooks);
		mv.setViewName("/body/mainIntroduce");
		
		return mv;
	}	



	
	
}
