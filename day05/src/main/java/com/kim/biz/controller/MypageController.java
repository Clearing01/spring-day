package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

public class MypageController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		MemberDAO mDAO=new MemberDAO();
		MemberVO mVO=new MemberVO();
		
		
		return "mypage";
	}

}
