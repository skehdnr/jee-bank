package com.bank.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.command.Order;
import com.bank.web.command.Receiver;
import com.bank.web.command.Sender;
import com.bank.web.command.Command;
import com.bank.web.command.MoveCommand;
import com.bank.web.daos.MemberDAO;
import com.bank.web.daosimpls.MemberDAOImpl;
import com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constants;
import com.bank.web.service.MemberService;
import com.bank.web.serviceimpl.MemberServiceImpl;


@WebServlet("/customer.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		MemberService service = new MemberServiceImpl();
		CustomerBean param = new CustomerBean();
		Receiver.inin(request);
		Receiver.cmd.execute();
		if(Receiver.cmd.getAction()==null) {
			Receiver.cmd.setPage();
		}
		switch(Receiver.cmd.getAction()) {
		case "join" :
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String ssn = request.getParameter("ssn");
			String name = request.getParameter("name");
			String credit = request.getParameter("credit");
			System.out.println("도착해ㅐㅐ음"+id+pass+ssn+name+credit);
			param.setCredit(credit);
			param.setId(id);
			param.setName(name);
			param.setPass(pass);
			param.setSsn(ssn);
			System.out.println("회원정보"+param.toString());
			
			service.join(param);
			Receiver.cmd.setPage("login");
			break;
		case "login": 
			id = request.getParameter("id");
			pass = request.getParameter("pass");
			param.setId(id);
			param.setPass(pass);
			CustomerBean cust =  service.login(param);
			if(cust == null) {
				System.out.println("성공");
                Receiver.cmd.setPage("login");
             }else {
            	 System.out.println("실패");
                Receiver.cmd.setPage("mypage");
             }
			request.setAttribute("customer",cust);
			break;
		case "existID" :
			break;
		}
		Sender.forward(request,  response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
