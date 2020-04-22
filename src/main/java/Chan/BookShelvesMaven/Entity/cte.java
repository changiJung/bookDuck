package Chan.BookShelvesMaven.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class cte {
	


	private Long idx;
	private Long parents_idx;
	private String name;
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public Long getParents_idx() {
		return parents_idx;
	}
	public void setParents_idx(Long parents_idx) {
		this.parents_idx = parents_idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
