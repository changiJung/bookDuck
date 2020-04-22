package Chan.BookShelvesMaven.DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CodeData {

	

	private Long itemId;

	@Id 
	private String code_cd;
	
	private String code_nm;
	

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getCode_cd() {
		return code_cd;
	}

	public void setCode_cd(String code_cd) {
		this.code_cd = code_cd;
	}

	public String getCode_nm() {
		return code_nm;
	}

	public void setCode_nm(String code_nm) {
		this.code_nm = code_nm;
	}

	
}
