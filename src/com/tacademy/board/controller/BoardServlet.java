package com.tacademy.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tacademy.board.dao.BoardDAO;
import com.tacademy.board.vo.Board;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "addBoard":
			doAddBoard(request, response);
			break;
		case "getBoard":
			doGetBoard(request, response);
			break;
		case "updateBoard":
			doUpdateBoard(request, response);
			break;
		case "deleteBoard":
			doDeleteBoard(request, response);
			break;
		}
	}

	protected void doAddBoard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		Board board = new Board();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));

		dao.doInsertBoard(board);

		response.sendRedirect("getBoardList.jsp");
	}
	
	protected void doGetBoard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//seq 따라 Board 객체를 DB에서 얻어온 후
			//getBoard.jsp로 board객체와 함께 이동
		BoardDAO dao = new BoardDAO();
		Board board = new Board();
		board.setSeq(request.getParameter("seq"));
		
		dao.getBoard(board);
		
		String returnURL = "getBoard.jsp";
		
		String format = request.getParameter("format"); //모바일 포맷으로 들어왔을 때 json처리해서 보내기
		if("json".equals(format)){
			Gson gson = new Gson();
			String result = gson.toJson(board);
			request.setAttribute("result", result); //모바일용
			returnURL = "result.jsp";
		}else{
			request.setAttribute("board", board); //웹 용
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);
	}
	
	protected void doUpdateBoard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		Board board = new Board();
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		board.setSeq(request.getParameter("seq"));
		
		dao.updateBoard(board);
		
		response.sendRedirect("getBoardList.jsp");
	}
	
	protected void doDeleteBoard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();

		Board board = new Board();
		board.setSeq(request.getParameter("seq"));
		
		dao.deleteBoard(board);
		response.sendRedirect("getBoardList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); // output stream을 관리하는 post만 적용됨.
												// get쪽에는 넣으나 마나 상관없음
		doGet(request, response);
	}

}
