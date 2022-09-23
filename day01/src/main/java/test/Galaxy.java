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
		System.out.println("������ ��ü�����Ϸ�");
	}
	
	public Galaxy(Watch watch,String battery) {
		System.out.println("������ ��ü�����Ϸ�333");
		this.watch=watch;
		this.battery=battery;
	}
	
	
	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
		System.out.println("watch ����: "+this.watch);
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
		System.out.println("���͸� ����: "+this.battery);
	}

	public void powerOn() {
		System.out.println("������ ���� ON");
	}
	public void powerOff() {
		System.out.println("������ ���� OFF");
	}
	public void volumeUp() {
		watch.volumeUp();
	}
	public void volumeDown() {
		watch.volumeDown();
	}
	
	
//	public void initMethod() {
//		System.out.println("��ü�� �ʱ�ȭ�ϴ� �۾��� ó���ϴ� �޼���...");
//	}
//	public void destroyMethod() {
//		System.out.println("��ü �޸𸮸� ������ �� ȣ���ϴ� �޼���...");
//	}
	
}
