package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

public class UpdateMemberController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberVO mvo = new MemberVO();
		MemberDAO mDAO = new MemberDAO();
		
		mvo.setMid(request.getParameter("mid"));
		mvo.setMpw(request.getParameter("mpw"));
		mDAO.updateMember(mvo);
		
		HttpSession session=request.getSession();
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		
		return mav;
	}

}
