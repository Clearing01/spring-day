package com.kim.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kim.biz.board.BoardVO;
import com.kim.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	@RequestMapping("/main.do")
	public ModelAndView selectAllBoard(BoardVO bVO,BoardDAO bDAO,ModelAndView mav) {

		List<BoardVO> datas=bDAO.selectAllBoard(bVO);

		mav.addObject("datas", datas);
		mav.setViewName("main.jsp");
		
		return mav;
	}
	
	@RequestMapping("/write.do")
	public String write() {
				
		return "write.jsp";
	}
	
	@RequestMapping("/board.do")
	public ModelAndView selectOneBoard(BoardVO bVO,BoardDAO bDAO,ModelAndView mav) {
		
		bVO=bDAO.selectOneBoard(bVO);
		mav.addObject("data", bVO);
		mav.setViewName("board.jsp");

		return mav;

	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO bVO,BoardDAO bDAO) {
		
		bDAO.insertBoard(bVO);
		
		return "redirect:main.do";
		
	}
	
	
	
}
