package test;

import org.springframework.stereotype.Component;

//@Component("aw")
public class AppleWatch implements Watch{
	public AppleWatch() {
		System.out.println("局敲况摹 按眉积己肯丰");
	}
	public void volumeUp() {
		System.out.println("局敲况摹 ++");
	}
	public void volumeDown() {
		System.out.println("局敲况摹 --");
	}
}
