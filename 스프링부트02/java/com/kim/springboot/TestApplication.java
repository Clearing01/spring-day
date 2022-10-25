package com.kim.springboot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.kim.springboot.test.Config;
import com.kim.springboot.test.Leader;
import com.kim.springboot.test.Member;

//@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
	//	SpringApplication.run(TestApplication.class, args);
		
		// 1. IoC 제공해줄 스프링 컨테이너 생성하기
		ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		// 싱글톤으로 객체 생성 및 관리됨
		
		// 2. @Bean 등록한 객체 사용해보기
		Leader leader1 = (Leader) ac.getBean("leaderA");
		leader1.hello();
		// @Configuration으로 해당 파일이 설정파일이라는것을 인식 생성되어 있는 클래스들을 Config파일에 설정 
		// -> @Bean으로 컨테이너에 의해 각 클래스들 객체화
		// -> Config 설정 파일에서 설정한 내용들이 ac에 주입 
		// -> ac에서 객체화된 leaderA를 가져와 leader1에 주입 
		
		Leader leader2 = (Leader) ac.getBean("kim");
		leader2.hello();
		//
		
		Member member = ac.getBean("memberB",Member.class);
		member.hello("main에서 작성");
		//
		
	}

}
