package com.kim.springboot.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링 컨테이너의 설정 파일 역할
public class Config {
	// 설정 파일
	
	@Bean // 객체화 공식
	public Leader leaderA() {
		// Setter 주입
		Leader leader1 = new Leader();
		leader1.setName("티모");
		leader1.setMember(new MemberA());
		return leader1;
	}
	
	@Bean(name="kim")
	public Leader leaderB() {
		return new Leader("아리",new MemberA());
	}
	
	@Bean
	public MemberA memberA() {
		return new MemberA();
	}
	
	@Bean
	public MemberB memberB() {
		return new MemberB();
	}
}
