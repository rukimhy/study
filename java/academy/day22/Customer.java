package academy.day22;

public class Customer implements Buy, Sell {
	@Override
	public void sell() {
		System.out.println("�����ϱ�");
	}

	@Override
	public void buy() {
		System.out.println("�Ǹ��ϱ�");
	}
}
