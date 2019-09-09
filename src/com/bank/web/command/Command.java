package com.bank.web.command;
import  javax.servlet.http.HttpServletRequest;
import com.bank.web.pool.Constants;
import lombok.Data;
@Data

public class Command implements Order{
   protected HttpServletRequest  request;
   protected String action, domain,  page, view;
   
   @Override
   public void execute(){
      setDomain();
      setPage();
	   this.view =  String.format(Constants.VIEW_PATH,  domain, page);     
   }
   public void setDomain() {
		String path = request.getServletPath(); //customer.do
		System.out.println("커맨드 : "+path);
		domain = path.replace(".do","");
		domain = domain.substring(1);
	}
   public void setPage() {
	   page = request.getParameter("page");
   }
}