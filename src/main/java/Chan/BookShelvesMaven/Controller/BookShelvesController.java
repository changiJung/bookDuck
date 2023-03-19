package Chan.BookShelvesMaven.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Chan.BookShelvesMaven.Entity.Book;
import Chan.BookShelvesMaven.Entity.BookComment;
import Chan.BookShelvesMaven.Entity.User;
import Chan.BookShelvesMaven.Repository.BookRepository;
import Chan.BookShelvesMaven.Repository.BookShelvesRepository;

@RestController
@CrossOrigin
@RequestMapping("/bookShelves/book")
public class BookShelvesController {

	@Resource
	private BookShelvesRepository bookShelvesRepository;

	@Resource
	private BookRepository bookRepository;

	@Autowired
	private CrawlerController crwaler;
	
	
	@Transactional
	@PostMapping
	public String registerBookShelvesBook(@ModelAttribute Book book, @AuthenticationPrincipal User user) {

		
		System.out.println(book.toString());
		
//		BookShelves bookShelves =  bookShelvesRepository.findByuserId(user.getUserId());
 
		book.setBookShelevesId(user.getBookShelves().getShelvesNo());
		//book.setTotPage(crwaler.bookPageCraler(book.getIsbn()));
				
		bookRepository.save(book);

		return "sucess";
	}

	@GetMapping
	public String getBookShelves(@AuthenticationPrincipal User user) {
		
		List<Book> books = new ArrayList<>();

		BookComment bookComment = new BookComment();
		
		books = bookRepository.findBybookShelevesId(user.getBookShelves().getShelvesNo());

//		System.out.println(books.size());
		
//		mv.addObject("books", books);
//		mv.addObject("bookComment", bookComment);
//		mv.setViewName("/body/mainShelves");
		
//		return mv;

		return null;
	}

	@PutMapping
	public Book updateBookShelves(@ModelAttribute Book book, @AuthenticationPrincipal User user) {

		Book nbook = new Book();
		
		nbook = bookRepository.findByIsbn(book.getIsbn());
		nbook.setCurPage(book.getCurPage());
		nbook.setBookShelevesId(user.getBookShelves().getShelvesNo());
		
		
		bookRepository.save(nbook);
				
		return nbook;
	}

	@DeleteMapping
	public String deleteBookShelves() {

		return null;
	}

}
