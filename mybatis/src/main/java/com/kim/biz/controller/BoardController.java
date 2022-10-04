package com.kim.biz.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.kim.biz.board.BoardService;
import com.kim.biz.board.BoardVO;

@Controller
@SessionAttributes("data") // "data라는 이름의 데이터가 Model 객체에 세팅이 된다면, 그것을 session에 기억시키겠다.
public class BoardController {
	
	@Autowired
	private BoardService boardService; // 비즈니스 컴포넌트. DAO를 직접 이용 xxx
		
	@ModelAttribute("scMap")
	public Map<String,String> searchConditionMap(){
		Map<String,String> scMap = new HashMap<String,String>();
		scMap.put("제목", "title"); // 뷰에 어떻게 보여야하는지, 모델에서 어떻게 쓰는지
		scMap.put("작성자", "writer");
		
		return scMap;
	}
	
	@RequestMapping("/main.do")
	public String selectAllBoard(BoardVO bVO,Model model) {
//		System.out.println("로그 main.do: "+bVO);
		if(bVO.getSearchCondition()==null) {
			bVO.setSearchCondition("");
		}
		if(bVO.getSearchContent()==null) {
			bVO.setSearchContent("");
		}
		List<BoardVO> datas=boardService.selectAllBoard(bVO);

		model.addAttribute("datas",datas);

		return "main.jsp";
	}
	
	@RequestMapping("/write.do")
	public String write() {
				
		return "write.jsp";
	}
	
	@RequestMapping("/board.do")
	public String selectOneBoard(BoardVO bVO,Model model) {
		
		bVO=boardService.selectOneBoard(bVO);
		model.addAttribute("data",bVO);

		return "board.jsp";

	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO bVO) throws IllegalStateException, IOException {
		
		MultipartFile uploadFile = bVO.getUploadFile();
		if(!uploadFile.isEmpty()) { // 업로드한 파일 존재여부 확인
			String fileName=uploadFile.getOriginalFilename(); // 업로드한 파일명
			uploadFile.transferTo(new File("C:\\Users\\Administrator\\git\\spring-day08\\test\\src\\main\\webapp\\images\\"+fileName));
				// 업로드한 파일을 지정한 경로에 저장
			System.out.println(fileName);
			bVO.setImg(fileName);
		}
		
		boardService.insertBoard(bVO);
		
		return "redirect:main.do";
		
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("data")BoardVO bVO) {
		boardService.updateBoard(bVO);
		
		return "redirect:main.do";
		
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO bVO) {
		
		boardService.deleteBoard(bVO);
		
		return "redirect:main.do";
		
	}
	
}
