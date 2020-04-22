package Chan.BookShelvesMaven.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import Chan.BookShelvesMaven.DAO.SearchBooks;

@Controller
public class IndexController {

	@GetMapping("/")
	private ModelAndView Main() {
				
		SearchBooks searchBooks = new SearchBooks();
		
		ModelAndView mv = new ModelAndView();
//		
		mv.addObject("searchBooks", searchBooks);
		mv.setViewName("main");
		
		return mv;
	}	
	
}
