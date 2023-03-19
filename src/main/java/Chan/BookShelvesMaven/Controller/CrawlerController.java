package Chan.BookShelvesMaven.Controller;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Repository
public class CrawlerController {


	//	현재 네이버 검색사이트 시스템 변동으로 인해서 사용불가
	public Long bookPageCraler(String isbn) {

		
		
		System.out.println("-----------------");
		System.out.println(isbn);
	
		String url = "https://book.naver.com/search/search.nhn?sm=sta_hty.book&sug=&where=nexearch&query="+ isbn; //크롤링할 url지정
		Document doc = null;        
		//Document에는 페이지의 전체 소스가 저장된다
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		//select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
		Element link = doc.select("ul#searchBiblioList").first();
		Elements aTag = link.select("a");		
		String linkHref = aTag.attr("href"); // "http://example.com/"
		
//		재크롤링
		
		System.out.println("-----------------");		
		System.out.println(linkHref);
		
		
		doc = null;        
		//Document에는 페이지의 전체 소스가 저장된다
		try {
			doc = Jsoup.connect(linkHref).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		//select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
		link = doc.select("div.book_info_inner").first();
		Elements emf = link.select("div");		
		
		Iterator<Element> ie1 = link.select("div").iterator();
		System.out.println(ie1);
		String page = "";
		
		


			for(Element el : link.select("div")) {    //

				if(el.text().startsWith("페이지")){
					page = el.text();
				}

			}
		
//		while (ie1.hasNext()) {

			//			
//			ie1.
//			
//			if(ie1.next().text().startsWith("원제") || ie1.next().text().startsWith("저자") ) {
//				page = ie1.next().text(); 
//			}
//			
//
//
//		}		
		System.out.println("-----------------PPPPPPPP");
		System.out.println(page);
		
//		결과값을 기준으로 공백처리 한 페이지  시작으로 처리함
		String target = " ";
		int target_num = page.indexOf(target); 
		String result; result = page.substring(target_num,(page.substring(target_num).indexOf("|")+target_num));
		System.out.println(result);
		System.out.println(result.trim());
		
		String pageResult = result.trim();
		
		
		Long pageTotNo = (long) Integer.parseInt(pageResult);
		
		
		return pageTotNo;
	}
	

	
}
