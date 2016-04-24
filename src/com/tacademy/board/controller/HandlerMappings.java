package com.tacademy.board.controller;

import java.util.HashMap;

public class HandlerMappings {
	private HashMap<String, Controller> maps = null;

	public HandlerMappings(){
		maps = new HashMap<String, Controller>();
		init();
	}
	public void init(){
		maps.put("/hello.do", new HelloController());
		maps.put("/login.do", new LoginController());
		maps.put("/logout.do", new LogoutController());
		maps.put("/addBoard.do", new AddBoardController());
		maps.put("/updateBoard.do", new UpdateBoardController());
		maps.put("/getBoard.do", new GetBoardController());
		maps.put("/getBoardJson.do", new GetBoardJsonController());
	}
	public Controller getController(String path){
		return maps.get(path);
	}
}
