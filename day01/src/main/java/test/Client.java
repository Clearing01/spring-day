package test;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		// Spring 컨테이너를 동작시킬수 있도록 코드작성
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		Phone phone = (Phone)factory.getBean("ip");
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		factory.close();

		
		// Spring 컨테이너야, 나 폰 객체를 가지고싶어!!
		// 객체를 요청하는 행동 == LookUp (객체요청: 컨테이너에게 가지고있는 객체중에 phone이라는 이름의 객체 요청)
		
		/*
		Phone phone = (Phone)factory.getBean("galaxy3");

		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		factory.close();
		*/
		
		/*
		BeanFactory bf=new BeanFactory();
		Phone phone=(Phone)bf.getBean("iphone");
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		*/
	}
}
