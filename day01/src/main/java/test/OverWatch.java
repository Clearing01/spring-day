package test;

public class OverWatch implements Watch{

	public OverWatch() {
		System.out.println("������ġ ��ü�����Ϸ�");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("������ġ ++");
	}

	@Override
	public void volumeDown() {
		System.out.println("������ġ --");
	}

}
