package Chan.BookShelvesMaven.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Chan.BookShelvesMaven.DAO.JwtRequest;
import Chan.BookShelvesMaven.DAO.SearchBooks;
import Chan.BookShelvesMaven.Entity.Book;
import Chan.BookShelvesMaven.Entity.BookComment;
import Chan.BookShelvesMaven.Entity.User;
import Chan.BookShelvesMaven.Repository.BookCommentRepositorySupport;
import Chan.BookShelvesMaven.Repository.BookRepository;
import Chan.BookShelvesMaven.Repository.BookShelvesRepository;
import Chan.BookShelvesMaven.Repository.BookShelvesRepositorySupport;
import Chan.BookShelvesMaven.Repository.UserRepository;

@Controller
@CrossOrigin
public class IndexController {

	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookShelvesRepository bookShelvesRepository;	

	@Autowired
	private BookShelvesRepositorySupport bookShelvesRepositorySupport;
	

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookCommentRepositorySupport bookCommentRepositorySupport;
	
		
	@GetMapping("/")
	private ModelAndView Main() {
				
		SearchBooks searchBooks = new SearchBooks();
		
		ModelAndView mv = new ModelAndView();

		Book book = new Book();

		mv.addObject("searchBooks", searchBooks);
		mv.addObject("book", book);
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

		SearchBooks searchBooks = new SearchBooks();
		
		Book book = new Book();

		mv.addObject("searchBooks", searchBooks);
		mv.addObject("book", book);

		mv.setViewName("/body/mainSearch");
		
		return mv;
	
	}	


	@GetMapping("/introduce")
	private ModelAndView MainIntroduceFragment() {
				
		
		ModelAndView mv = new ModelAndView();


		mv.setViewName("/body/mainIntroduce");
		
		return mv;
	}	


	@GetMapping("/shelves")
	private ModelAndView MainShelvesFragment(@AuthenticationPrincipal User user) {
				
		ModelAndView mv = new ModelAndView();
						
		List<Book> books = new ArrayList<>();

		BookComment bookComment = new BookComment();
		
		books = bookRepository.findBybookShelevesId(user.getBookShelves().getShelvesNo());

		System.out.println(books.size());
		
		mv.addObject("books", books);
		mv.addObject("bookComment", bookComment);
		mv.setViewName("/body/mainShelves");
		
		return mv;
	}	



	
	@GetMapping("/test")
	private String test() {
				
		
//		ModelAndView mv = new ModelAndView();
//
//		SearchBooks searchBooks = new SearchBooks();
//		
//		Book book = new Book();
//
//		mv.addObject("searchBooks", searchBooks);
//		mv.addObject("book", book);
//
//		mv.setViewName("/body/mainSearch");
		
		return "test";
	
	}	



	@GetMapping("/bookComment")
	private ModelAndView BookComentFragment(@AuthenticationPrincipal User user, @RequestParam(name = "isbn") String isbn ) {

		ModelAndView mv = new ModelAndView();
		
		
		List<BookComment> bookComment = bookCommentRepositorySupport.findByBook(user.getUserId(), isbn);

		

		mv.addObject("bookComment", bookComment);
		mv.setViewName("/body/bookCommentPart");
		
		return mv;

	}
	
}
