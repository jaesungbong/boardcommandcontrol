package com.tacademy.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("servlet");
		String uri = request.getRequestURI(); //get방식 파라미터 안보이게 하기
		String action = uri.substring(uri.lastIndexOf("/")); //lastIndexOf 끝에서부터 찾기
		System.out.println("uri : "+ uri);
		System.out.println("action : " + action);
		
		Controller controller = null;
		HandlerMappings mappings = new HandlerMappings();
		controller = mappings.getController(action);
		String returnURL = "login.jsp";	
		try{
			returnURL = controller.handleRequest(request, response);
		}catch(Exception e){
			System.out.println("e : " + e);
			returnURL = "login.jsp";
		}
		switch (returnURL) {
		case "login.jsp":
		case "getBoardList.jsp":
			response.sendRedirect(returnURL);
			break;
		default:
			RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
			dispatcher.forward(request, response);
			break;
		}
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
