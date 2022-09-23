package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

/*
 package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}wd 
 */

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그: 로그인 컨트롤러");
		String mid=request.getParameter("mid");
		String mpw=request.getParameter("mpw");
		MemberDAO mDAO=new MemberDAO();
		MemberVO mVO=new MemberVO();
		
		mVO.setMid(mid);
		mVO.setMpw(mpw);
		mVO = mDAO.selectOneMember(mVO);
		
		ModelAndView mav = new ModelAndView();
		if(mVO==null) {
			mav.setViewName("login.jsp");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("member", mVO);
			mav.setViewName("main.do");
		}
		return mav;
	}
	
	/*
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String mid=request.getParameter("mid");
		String mpw=request.getParameter("mpw");
		MemberDAO mDAO=new MemberDAO();
		MemberVO mVO=new MemberVO();
		
		mVO.setMid(mid);
		mVO.setMpw(mpw);
		mVO = mDAO.selectOneMember(mVO);
		
		if(mVO==null) {
			return "login"; // VR가 .jsp를 추가하기 때문에 생략해서 반환
		}
		else {
			session.setAttribute("member", mVO);
			return "main.do";
		}
	}
	*/
}
