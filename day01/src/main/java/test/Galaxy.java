package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("gp")
public class Galaxy implements Phone{
	
	@Autowired
//	@Qualifier("gw")
	private Watch watch;
	
	private String battery;
	
	public Galaxy() {
		System.out.println("갤럭시 객체생성완료");
	}
	
	public Galaxy(Watch watch,String battery) {
		System.out.println("아이폰 객체생성완료333");
		this.watch=watch;
		this.battery=battery;
	}
	
	
	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
		System.out.println("watch 연동: "+this.watch);
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
		System.out.println("배터리 주입: "+this.battery);
	}

	public void powerOn() {
		System.out.println("갤럭시 전원 ON");
	}
	public void powerOff() {
		System.out.println("갤럭시 전원 OFF");
	}
	public void volumeUp() {
		watch.volumeUp();
	}
	public void volumeDown() {
		watch.volumeDown();
	}
	
	
//	public void initMethod() {
//		System.out.println("객체를 초기화하는 작업을 처리하는 메서드...");
//	}
//	public void destroyMethod() {
//		System.out.println("객체 메모리를 해제할 때 호출하는 메서드...");
//	}
	
}
