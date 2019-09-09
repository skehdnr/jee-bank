package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constants;
import com.bank.web.service.MemberService;
import com.bank.web.serviceimpl.MemberServiceImpl;

public class LoginCommand extends MoveCommand{
	public LoginCommand(HttpServletRequest request) throws Exception {
		super(request);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void execute() {
		super.execute();
		MemberService service = new MemberServiceImpl();
		CustomerBean param = new CustomerBean();
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		id = request.getParameter("id");
		pass = request.getParameter("pass");
		param.setId(id);
		param.setPass(pass);
		CustomerBean cust =  service.login(param);
		String domain = "customer";
		String page = "login";
		if(id.equals(service.login(cust).getId())&&pass.equals(service.login(cust).getPass())) {
			System.out.println(action);
			Receiver.cmd.setPage("mypage");
         }else {
        	 Receiver.cmd.setView(String.format(Constants.VIEW_PATH,domain,page));
//        	 Receiver.cmd.setPage(page);
        	 System.out.println("실패"+page);
        	
         }
		request.setAttribute("customer",cust);
		System.out.println(page+domain);
		System.out.println("로그인 후 갈 페이지:"+Receiver.cmd.getView());
	}
}
