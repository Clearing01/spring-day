package com.kim.springboot.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Leader {
	@Value("티모") // setter의 역할을 수행
	private String name;
	@Autowired
	@Qualifier("memberA")
	private Member member;
	public Leader() {
		
	}
	public Leader(String name, Member member) {
		this.name=name;
		this.member=member;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public void hello() {
		member.hello(name+": 안녕하세요!");
	}
	@Override
	public String toString() {
		return "Leader [name=" + name + ", member=" + member + "]";
	}
	
}
