package test;

import org.springframework.stereotype.Component;

//@Component("gw")
public class GalaxyWatch implements Watch{
	
	public GalaxyWatch() {
		System.out.println("갤럭시워치 객체생성완료");
	}

	@Override
	public void volumeUp() {
		System.out.println("갤럭시워치 ++");

	}

	@Override
	public void volumeDown() {
		System.out.println("갤럭시워치 --");
	}

}
