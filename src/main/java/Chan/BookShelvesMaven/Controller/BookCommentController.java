package Chan.BookShelvesMaven.Controller;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Chan.BookShelvesMaven.Entity.Book;
import Chan.BookShelvesMaven.Entity.BookComment;
import Chan.BookShelvesMaven.Entity.User;
import Chan.BookShelvesMaven.Repository.BookCommentRepository;
import Chan.BookShelvesMaven.Repository.BookCommentRepositorySupport;
import Chan.BookShelvesMaven.Repository.BookRepository;
import Chan.BookShelvesMaven.Repository.BookShelvesRepository;

@RestController
@RequestMapping("/bookShelves/bookComment")
public class BookCommentController {

	
	@Resource
	private BookShelvesRepository bookShelvesRepository;

	@Resource
	private BookCommentRepository bookCommentRepository;
	
	@Resource
	private BookCommentRepositorySupport bookCommentRepositorySupport;	

	@Transactional
	@PostMapping
	public BookComment registerBookComment(@ModelAttribute BookComment bookComment, @AuthenticationPrincipal User user) {

		bookComment.setUserId(user.getUserId());
		
		bookCommentRepository.save(bookComment);
		
		return bookComment;
	}

	@GetMapping
	public BookComment getBookComment(@AuthenticationPrincipal User user, @RequestParam(name = "isbn") String isbn) {

		BookComment bookComment = new BookComment();

		bookComment = bookCommentRepository.findOne(isbn, user.getUserId());
		
		return bookComment;
	}

	@PutMapping
	public BookComment updateBookShelves(@ModelAttribute BookComment bookComment, @AuthenticationPrincipal User user) {

		bookComment.setUserId(user.getUserId());
		
		bookCommentRepository.save(bookComment);
		
		return bookComment;
		
	}

	@DeleteMapping
	public String deleteBookShelves() {

		return null;
	}

	
	
}
