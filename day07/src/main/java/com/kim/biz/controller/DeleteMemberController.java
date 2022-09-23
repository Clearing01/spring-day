package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

public class DeleteMemberController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		MemberVO mvo = new MemberVO();
		MemberDAO mDAO = new MemberDAO();
		mvo = (MemberVO)session.getAttribute("member");
		
		mDAO.deleteMember(mvo);
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		return mav;
	}

}
