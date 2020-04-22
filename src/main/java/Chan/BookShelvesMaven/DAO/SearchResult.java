package Chan.BookShelvesMaven.DAO;



public class SearchResult {

	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getStart() {
		return start;
	}
	public void setStart(Long start) {
		this.start = start;
	}
	public Long getDisplay() {
		return display;
	}
	public void setDisplay(Long display) {
		this.display = display;
	}
	private Long total;
	private Long start;
	private Long display;
	
	
}
