package com.kim.springboot.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
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
		}
		else {
			System.out.println("동일하지 않습니다.");
		}
		
		return "루트(표지) 페이지";
	}
}
