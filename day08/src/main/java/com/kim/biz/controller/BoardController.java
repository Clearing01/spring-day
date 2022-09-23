package com.kim.biz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kim.biz.board.BoardVO;
import com.kim.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("data") // "data라는 이름의 데이터가 Model 객체에 세팅이 된다면, 그것을 session에 기억시키겠다.
public class BoardController {
	
	@ModelAttribute("scMap")
	public Map<String,String> searchConditionMap(){
		Map<String,String> scMap = new HashMap<String,String>();
		scMap.put("제목", "title"); // 뷰에 어떻게 보여야하는지, 모델에서 어떻게 쓰는지
		scMap.put("작성자", "writer");
		
		return scMap;
	}
	
	@RequestMapping("/main.do")
	public String selectAllBoard(BoardVO bVO,BoardDAO bDAO,Model model) {
//		System.out.println("로그 main.do: "+bVO);
		List<BoardVO> datas=bDAO.selectAllBoard(bVO);

		model.addAttribute("datas",datas);

		return "main.jsp";
	}
	
	@RequestMapping("/write.do")
	public String write() {
				
		return "write.jsp";
	}
	
	@RequestMapping("/board.do")
	public String selectOneBoard(BoardVO bVO,BoardDAO bDAO,Model model) {
		
		bVO=bDAO.selectOneBoard(bVO);
		model.addAttribute("data",bVO);

		return "board.jsp";

	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO bVO,BoardDAO bDAO) {
		
		bDAO.insertBoard(bVO);
		
		return "redirect:main.do";
		
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("data")BoardVO bVO,BoardDAO bDAO) {
		bDAO.updateBoard(bVO);
		
		return "redirect:main.do";
		
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO bVO,BoardDAO bDAO) {
		
		bDAO.deleteBoard(bVO);
		
		return "redirect:main.do";
		
	}
	
}
