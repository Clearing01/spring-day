package test;

import org.springframework.stereotype.Component;

//@Component("gw")
public class GalaxyWatch implements Watch{
	
	public GalaxyWatch() {
		System.out.println("�����ÿ�ġ ��ü�����Ϸ�");
	}

	@Override
	public void volumeUp() {
		System.out.println("�����ÿ�ġ ++");

	}

	@Override
	public void volumeDown() {
		System.out.println("�����ÿ�ġ --");
	}

}
