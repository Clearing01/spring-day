package com.kim.biz.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping { // 싱글톤 패턴이 유지됨 (객체의 무분별한 생성을 막을 수 있음)
	// input: 어떤 요청에 대해 == String
	// output: 무슨 Controller 객체를 제공해야하는지 == Controller
	/*
	private Map<String,Controller> mappings; // 의존관계 -> DI => 생성자 주입
	
	public HandlerMapping() {
		mappings=new HashMap<String,Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/main.do", new MainController());
		mappings.put("/mypage.do", new MypageController());
		mappings.put("/signin.do", new SigninController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/update.do", new UpdateController());
	}
	
	public Controller getController(String command) {
		return mappings.get(command);
	}
	 */	
}
