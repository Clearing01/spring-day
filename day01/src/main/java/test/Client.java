package test;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		// Spring �����̳ʸ� ���۽�ų�� �ֵ��� �ڵ��ۼ�
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		Phone phone = (Phone)factory.getBean("ip");
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		factory.close();

		
		// Spring �����̳ʾ�, �� �� ��ü�� ������;�!!
		// ��ü�� ��û�ϴ� �ൿ == LookUp (��ü��û: �����̳ʿ��� �������ִ� ��ü�߿� phone�̶�� �̸��� ��ü ��û)
		
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
