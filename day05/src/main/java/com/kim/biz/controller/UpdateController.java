package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

public class UpdateController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		MemberDAO mDAO=new MemberDAO();
		MemberVO mVO=new MemberVO();
		
		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));
		mDAO.updateMember(mVO);
		session.invalidate();
		
		return "login";
	}

}
