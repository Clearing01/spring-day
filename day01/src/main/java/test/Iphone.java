package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ip")
public class Iphone implements Phone{
	
	@Autowired
//	@Qualifier("aw")
	private Watch watch; // �������� -> ������ ����(DI)�� �ʿ��� ����
	private int number;
	
	public Iphone() {
		System.out.println("������ ��ü�����Ϸ�");
	}
	

	public Iphone(Watch watch) {
		System.out.println("������ ��ü�����Ϸ�22");
		this.watch=watch;
	}
	public Iphone(Watch watch,int number) {
		System.out.println("������ ��ü�����Ϸ�333");
		this.watch=watch;
		this.number=number;
	}
	
	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
		System.out.println("setter ȣ��� -1");
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
		System.out.println("setter ȣ��� -2");
	}
	
	@Override
	public void powerOn() {
		System.out.println("������ ���� ON: "+this.number);
	}
	@Override
	public void powerOff() {
		System.out.println("������ ���� OFF");
	}
	@Override
	public void volumeUp() {
		watch.volumeUp();
	}
	@Override
	public void volumeDown() {
		watch.volumeDown();
	}
}
