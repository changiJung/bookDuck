package Chan.BookShelvesMaven.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Chan.BookShelvesMaven.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User findByuserId(String userId);
	
//	public List<User> findByuserId(String userId);

	public List<User> findByuserNm(String name); 
	
	// like검색도 가능 
	public List<User> findByuserNmLike(String keyword);

	

}
