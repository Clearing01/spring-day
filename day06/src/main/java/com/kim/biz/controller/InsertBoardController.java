package com.kim.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.kim.biz.board.BoardVO;
import com.kim.biz.board.impl.BoardDAO;

public class InsertBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardVO bvo = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		
		bvo.setTitle(request.getParameter("title"));
		bvo.setWriter(request.getParameter("writer"));
		bvo.setContent(request.getParameter("content"));
		bDAO.insertBoard(bvo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:main.do");
		return mav;
	}

}
