package test;

public class OverWatch implements Watch{

	public OverWatch() {
		System.out.println("오버워치 객체생성완료");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("오버워치 ++");
	}

	@Override
	public void volumeDown() {
		System.out.println("오버워치 --");
	}

}
