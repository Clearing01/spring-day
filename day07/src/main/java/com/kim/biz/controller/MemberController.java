package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

@Controller
public class MemberController {
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String index() {
		return "login.jsp";
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView selectOneMember(MemberVO mVO,MemberDAO mDAO,ModelAndView mav,HttpSession session) {

		mVO=mDAO.selectOneMember(mVO);
		if(mVO==null) {
			mav.setViewName("login.jsp");
		}
		else {
			session.setAttribute("member", mVO);
			mav.setViewName("redirect:main.do");
		}
		
		return mav;
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.do";
	}
	
	@RequestMapping("/mypage.do")
	public String mypage() {		
		
		return "mypage.jsp";
	}
	
	@RequestMapping("/signin.do")
	public ModelAndView insertMember(MemberVO mVO,MemberDAO mDAO,ModelAndView mav) {
		
		mDAO.insertMember(mVO);
		
		mav.setViewName("redirect:login.do");
		
		return mav;
		
	}
	
	@RequestMapping("/updateMember.do")
	public ModelAndView updateMember(MemberVO mVO,MemberDAO mDAO,ModelAndView mav,HttpSession session) {
		

		mDAO.updateMember(mVO);
		
		session.invalidate();
		
		mav.setViewName("redirect:login.do");
		
		return mav;
		
	}
	
	@RequestMapping("/deleteMember.do")
	public String deleteMember(MemberVO mVO,MemberDAO mDAO,HttpSession session) {

		mVO = (MemberVO)session.getAttribute("member");
		
		mDAO.deleteMember(mVO);
		session.invalidate();
		
		return "redirect:login.do";
 
	}
	
}
