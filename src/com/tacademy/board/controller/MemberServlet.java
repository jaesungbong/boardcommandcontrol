package com.tacademy.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tacademy.board.dao.MemberDAO;
import com.tacademy.board.vo.Member;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch (action) {
		case "login":
			doLogin(request, response);
			break;
		case "logout":
			doLogin(request, response);
			break;
		}
	}

	void doLogin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		
		dao.doLogin(member);
		if(member.getName() == null){
			//out.println("{status : \"success\"}");
			response.sendRedirect("login.jsp");
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			response.sendRedirect("getBoardList.jsp");
			//out.println("fail");
		}		
	}
	
	void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션 정보가 있으면 지우고 login.jsp로 이동
		HttpSession session = request.getSession(); //ture 와 false를 쓸 수 있다. 
		//true서버쪽에 세션이 없으면 세션을 담을 수 있는 변수를 생성하여 사용. 있으면 있는 세션을 사용
		//false서버쪽에 세션이 없으면 null 반환. 있으면 있는 세션을 사용
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
