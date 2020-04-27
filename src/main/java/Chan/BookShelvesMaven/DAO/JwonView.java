package Chan.BookShelvesMaven.DAO;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.servlet.view.AbstractView;


public class JwonView extends AbstractView {

	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(Map model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("jsonview start ");
		Object obj = model.get("jsonData");
		
		JSONObject jsonObj =  new JSONObject();
		if( obj instanceof Map){
			List<Map<String,String>> list = new ArrayList<Map<String,String>>();
			list.add((Map)obj);
			jsonObj.put("jsonData", list);
		}else if( obj instanceof List){
			jsonObj.put("jsonData", (List)obj);
		}else{
			jsonObj.put("jsonData", obj);
		}
		
		response.setContentType( "text/text; charset=euc-kr");
        response.setHeader("Cache-Control", "no-cache");
        
		PrintWriter out = response.getWriter();
		out.write(jsonObj.toString());
		out.flush();
				
	}

	
}
