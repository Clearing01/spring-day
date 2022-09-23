package test;

public class AppleWatch implements Watch {
	public AppleWatch() {
		System.out.println("애플워치 객체생성완료");
	}
	@Override
	public void volumeUp() {
		System.out.println("애플워치 ++");
	}
	@Override
	public void volumeDown() {
		System.out.println("애플워치 --");
	}
}
