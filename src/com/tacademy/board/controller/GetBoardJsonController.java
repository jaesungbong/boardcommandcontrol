package com.tacademy.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tacademy.board.dao.BoardDAO;
import com.tacademy.board.vo.Board;

public class GetBoardJsonController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		Board board = new Board();
		board.setSeq(request.getParameter("seq"));
		
		dao.getBoard(board);
		Gson gson = new Gson();
		String result =gson.toJson(board);
		
		String returnURL = "result.jsp";
		request.setAttribute("board", board);
		return returnURL;
	}

}
