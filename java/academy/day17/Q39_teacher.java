package academy.day17;

import java.util.Random;
import java.util.concurrent.TimeUnit;

//�޸��⼱��
class Player {
	// ����, �̵��Ÿ� , ���� ��Ȳ(���)
	String nara;
	int move = 0;

	Player(String nara) {
		// TODO Auto-generated constructor stub
		this.nara = nara;
	}

	void checkMove(Random r, boolean check) // check�� true�̸� �����Ȳ false�̸� ��������
	{
		if (!check) {
			move += r.nextInt(10) + 1;
		}

	}
}

public class Q39_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		boolean check = true;
		Player[] players = new Player[4];

		String[] country = { "�ѱ�", "�߱�", "�̱�", "���þ�" };

		for (int i = 0; i < players.length; i++) {
			players[i] = new Player(country[i]);
		}

		while (check) {
			int d = r.nextInt(4);
			System.out.println("���� > " + (d + 1) + "�� ����");
			for (int i = 0; i < players.length; i++) {
				if (i == d) {
					players[i].checkMove(r, true);
				} else {
					players[i].checkMove(r, false);
				}
				if (players[i].move >= 100) {
					check = false;
				}
				System.out.println((i + 1) + "�� ����" + players[i].nara + "������ : " + players[i].move + "M");
			}
			System.out.println();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		int max = 0;

		for (int i = 0; i < players.length; i++) {
			if (players[max].move < players[i].move) {
				max = i;
			}
		}

		System.out.println("��±��� " + players[max].nara + "�Դϴ�.");
		/*
		 * //1�������� ���
		 * if(players[0].move> players[1].move && players[0].move> players[2].move &&
		 * players[0].move> players[3].move)
		 * {
		 * System.out.println("��±��� "+players[0].nara+"�Դϴ�.");
		 * 
		 * }
		 * //2�������� ���
		 * if(players[1].move> players[0].move && players[1].move> players[2].move &&
		 * players[1].move> players[3].move)
		 * {
		 * System.out.println("��±��� "+players[0].nara+"�Դϴ�.");
		 * 
		 * }
		 * //3�������� ���
		 * if(players[2].move> players[0].move && players[2].move> players[1].move &&
		 * players[2].move> players[3].move)
		 * {
		 * System.out.println("��±��� "+players[0].nara+"�Դϴ�.");
		 * 
		 * }
		 * //4�������� ���
		 * if(players[3].move> players[0].move && players[3].move> players[1].move &&
		 * players[3].move> players[2].move)
		 * {
		 * System.out.println("��±��� "+players[0].nara+"�Դϴ�.");
		 * 
		 * }
		 */
	}

}
