package com.kim.springboot.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "커맨드 객체 사용하는 예제: 사용자로부터 데이터를 받아올 예정";
	}
	
	// Request 객체에서 직접 받아옴
	@RequestMapping("/test1")
	public String test1(HttpServletRequest req,Model model) {
		model.addAttribute("id",req.getParameter("id"));
		
		String name = req.getParameter("name"); // 코드 가독성 증가
		model.addAttribute("name",name);
		return "test1";
	}
	
	// @RequestParam VO에 없는 값들을 일시적으로 받아올 때 용이
	@RequestMapping("/test2")
	public String test2(@RequestParam("id")String id,@RequestParam("name")String name,Model model) {
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		return "test2";
	}
	
	@RequestMapping("/test3")
	public String test3(Student student, Model model) {
		return "test3";
	}
	
	// 4. 경로에 변수를 추가하는 방식
	@RequestMapping("/test4/{studentId}/{studentName}")	
	public String test4(@PathVariable String studentId,@PathVariable String studentName,Model model) {
		model.addAttribute("id",studentId);
		model.addAttribute("name",studentName);
		return "test4";
	}
	
	/*
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "MAV"; // model and view
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("name","apple");
		return "index";
	}
	
	@RequestMapping("/test")
	public ModelAndView test(ModelAndView mav) {
		List<String> datas = new ArrayList<String>();
		datas.add("test1");
		datas.add("test2");
		datas.add("test3");
		mav.addObject("datas",datas);
		mav.addObject("test","테스트");
		mav.addObject("name","banana");
		mav.setViewName("sub/test");
		return mav;
	}
	*/
//	@RequestMapping("/")
//	public @ResponseBody String root() {
//		return "JSP를 SpringBoot에서 이용해보자!";
//	}
//	@RequestMapping("/index")
//	public String index() {
//		return "index"; // 실제로 호출되는 페이지의 경로는 /WEB-INF/views/index.jsp이다!
//	}
//	@RequestMapping("/test")
//	public String test() {
//		return "sub/test";
//	}
	
	/*
	@Autowired
	Leader leader1;
	@Autowired
	Leader leader2;
	@Autowired
	@Qualifier("memberB")
	Member member;

	@RequestMapping("/")
	public @ResponseBody String root() {
		leader1.hello();
		leader1.setMember(member);
		leader1.hello();

		if(leader1 == leader2) {
			System.out.println("동일한 객체입니다.");
			System.out.println(leader2);
		}
		else {
			System.out.println("동일하지 않습니다.");
		}

		return "루트(표지) 페이지";
	}
	 */
}
