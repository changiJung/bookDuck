package Chan.BookShelvesMaven.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Chan.BookShelvesMaven.Entity.User;
import Chan.BookShelvesMaven.Repository.UserRepository;
import Chan.BookShelvesMaven.Repository.UserRepositorySupport;

@RestController
@RequestMapping("/ajax")
public class AjaxController {

	
	@Autowired
	private UserRepositorySupport userRepositorySupport;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/userIdChk")
	private ResponseEntity userIdChk(@RequestParam(name = "userId") String userId) {
						
		
		User user = userRepository.findByuserId(userId);
	
		String result = "sucess";
				
	
		if(!isEmpty(user)) {								
			result = "fail";
		} 
		
	     return ResponseEntity.status(HttpStatus.OK).body(result);
				
	}
	

	 public static boolean isEmpty(Object s) {
	        if (s == null) {
	            return true;
	        }
	        if ((s instanceof String) && (((String)s).trim().length() == 0)) {
	            return true;
	        }
	        if (s instanceof Map) {
	            return ((Map<?, ?>)s).isEmpty();
	        }
	        if (s instanceof List) {
	            return ((List<?>)s).isEmpty();
	        }
	        if (s instanceof Object[]) {
	            return (((Object[])s).length == 0);
	        }
	        return false;
	    }
	

		 
	
}
