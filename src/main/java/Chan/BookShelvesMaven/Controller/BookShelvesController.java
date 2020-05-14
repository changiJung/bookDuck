package Chan.BookShelvesMaven.Controller;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Chan.BookShelvesMaven.Entity.Book;
import Chan.BookShelvesMaven.Entity.BookShelves;
import Chan.BookShelvesMaven.Entity.User;
import Chan.BookShelvesMaven.Repository.BookRepository;
import Chan.BookShelvesMaven.Repository.BookShelvesRepository;

@RestController
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
		book.setTotPage(crwaler.bookPageCraler(book.getIsbn()));
				
		bookRepository.save(book);

		return "sucess";
	}

	@GetMapping
	public String getList() {

		return null;
	}

	@PutMapping
	public String updateBookShelves() {

		return null;
	}

	@DeleteMapping
	public String deleteBookShelves() {

		return null;
	}

}
