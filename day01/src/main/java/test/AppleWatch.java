package test;

import org.springframework.stereotype.Component;

//@Component("aw")
public class AppleWatch implements Watch{
	public AppleWatch() {
		System.out.println("���ÿ�ġ ��ü�����Ϸ�");
	}
	public void volumeUp() {
		System.out.println("���ÿ�ġ ++");
	}
	public void volumeDown() {
		System.out.println("���ÿ�ġ --");
	}
}
