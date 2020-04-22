package Chan.BookShelvesMaven.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {

	@Id
	private Long idx;
	
	private Long parents_idx;
	
	
	private String name;
	
}
