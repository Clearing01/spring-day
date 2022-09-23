package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

/*
package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
 */

public class LoginController {

	public void selectOneMember(HttpServletRequest request) {
		MemberVO mVO=new MemberVO();
		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));

		MemberDAO mDAO=new MemberDAO();
		mVO=mDAO.selectOneMember(mVO);

		if(mVO==null) {
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("member", mVO);

		}
	}


	/*
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberVO mVO=new MemberVO();
		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));

		MemberDAO mDAO=new MemberDAO();
		mVO=mDAO.selectOneMember(mVO);

		ModelAndView mav=new ModelAndView();
		if(mVO==null) {
			mav.setViewName("redirect:login.jsp");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("member", mVO);

			mav.setViewName("redirect:main.do");
		}
		return mav;
	}
	 */

	/*
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String mid=request.getParameter("mid");
		String mpw=request.getParameter("mpw");
		MemberVO mVO=new MemberVO();
		mVO.setMid(mid);
		mVO.setMpw(mpw);

		MemberDAO mDAO=new MemberDAO();
		mVO=mDAO.selectOneMember(mVO);

		if(mVO==null) {
			return "login"; // VR�� .jsp�� �߰��ϱ⶧���� �����ؼ� ��ȯ
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("member", mVO);

			return "main.do";
		}
	}
	 */

}
