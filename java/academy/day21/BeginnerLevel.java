package academy.day21;

public class BeginnerLevel extends PlayerLevel {
	@Override
	public void run() {
		System.out.println("õõ�� �޸��ϴ�.");
	}

	@Override
	public void jump() {
		System.out.println("jump�� �� �𸨴ϴ�.");
	};

	@Override
	public void turn() {
		System.out.println("turn�� �� �𸨴ϴ�.");
	};

	@Override
	public void showLevelMessage() {
		System.out.println("****�ʺ��� �����Դϴ�.****");
	};
}
