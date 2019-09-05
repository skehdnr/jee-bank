package com.bank.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.daos.MemberDAO;
import com.bank.web.daosimpls.MemberDAOImpl;
import com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constants;
import com.bank.web.service.MemberService;
import com.bank.web.serviceimpl.MemberServiceImpl;


@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String dest = request.getParameter("desk");
		MemberService service = new MemberServiceImpl();
		CustomerBean param = new CustomerBean();
		MemberDAO dao = new MemberDAOImpl();
		
		switch(request.getParameter("action")) {
		case "move" :
			request.getRequestDispatcher
			(String.format(Constants.VIEW_PATH,"customer",request.getParameter("dest")))
			.forward(request, response);
			break;
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
			request.getRequestDispatcher
			(String.format(Constants.VIEW_PATH,"customer",request.getParameter("dest")))
			.forward(request, response);
			break;
		case "login": 
			id = request.getParameter("id");
			pass = request.getParameter("pass");
			param.setId(id);
			param.setPass(pass);
			if(service.login(param).getId().equals(id)&&service.login(param).getPass().equals(pass)) {
				request.setAttribute("customer", param);
				request.getRequestDispatcher
				(String.format(Constants.VIEW_PATH,"customer",request.getParameter("dest")))
				.forward(request, response);
			}else{
				request.getRequestDispatcher
				(String.format(Constants.VIEW_PATH,"customer",request.getParameter("action")))
				.forward(request, response);
			}
			break;
		case "existID" :
			break;
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
