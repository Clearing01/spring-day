package com.kim.biz.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kim.biz.member.MemberService;
import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

@Controller
@SessionAttributes("member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String index() {
		return "login.jsp";
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String selectOneMember(MemberVO mVO,Model model) {

		mVO=memberService.selectOneMember(mVO);
		if(mVO==null) {
			return "login.jsp";
		}
		else {
			model.addAttribute("member",mVO);
			return "redirect:main.do";
		}
		
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
	public String insertMember(MemberVO mVO) {
		
		memberService.insertMember(mVO);
		
		return "redirect:login.do";
		
	}
	
	@RequestMapping("/updateMember.do")
	public String updateMember(MemberVO mVO,HttpSession session) {
		
		memberService.updateMember(mVO);
		
		session.invalidate();
				
		return "redirect:login.do";
		
	}
	
	@RequestMapping("/deleteMember.do")
	public String deleteMember(@ModelAttribute("member")MemberVO mVO,HttpSession session) {
		
		
		memberService.deleteMember(mVO);
		session.invalidate();
		
		return "redirect:login.do";
 
	}
	
}
