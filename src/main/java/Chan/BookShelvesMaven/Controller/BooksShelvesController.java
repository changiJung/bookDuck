package Chan.BookShelvesMaven.Controller;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Chan.BookShelvesMaven.Repository.BookShelvesRepository;

@RestController
@RequestMapping("/bookShelves")
public class BooksShelvesController {

	@Resource
	private BookShelvesRepository bookShelvesRepository;
	
	@Transactional
	@PostMapping
	public String postUser() {
		return "hey post";
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
