package academy.day23;

import java.util.Random;

interface Repairable {
}

interface Heal {
}

class Unit {
	int hitPoint;
	final int MAX_HP;
	final int MAX_ATK;

	Unit(int hp, int atk) {
		MAX_HP = hp;
		MAX_ATK = atk;
	}

	void attack(Unit u, int count) {

	};
}

class Tank extends Unit implements Repairable {
	Tank() {
		super(45, 4);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Tank";
	}

	@Override
	void attack(Unit u, int count) {
		u.hitPoint -= super.MAX_ATK;
		System.out.println(this.toString() + "�� ����! " + u.toString() + "[" + count + "]" + "���� " + super.MAX_ATK
				+ "��ŭ ���ظ� �־���.");
	}
}

class Marine extends Unit implements Heal {
	Marine() {
		super(50, 6);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Marine";
	}

	@Override
	void attack(Unit u, int count) {
		u.hitPoint -= super.MAX_ATK;
		System.out.println(this.toString() + "�� ����! " + u.toString() + "[" + count + "]" + "���� " + super.MAX_ATK
				+ "��ŭ ���ظ� �־���.");
	}
}

class SCV extends Unit implements Repairable {
	SCV() {
		super(100, 100);
	}

	void repair(Repairable r, int count) {
		if (r instanceof Unit) {
			Unit u = (Unit) r;
			if (u.hitPoint != u.MAX_HP) {
				if (u.MAX_HP - u.hitPoint < 5) {
					u.hitPoint = u.MAX_HP;
					System.out.println(this.toString() + "�� " + u.toString() + "[" + count + "]" + "�� ü���� +"
							+ (u.MAX_HP - u.hitPoint) + " ȸ���߽��ϴ�.");
				} else {
					u.hitPoint += 5;
					System.out.println(
							this.toString() + "�� " + u.toString() + "[" + count + "]" + "�� ü���� +5 ȸ���߽��ϴ�.");
				}
			} else {
				System.out.println("�̹� �������� ���� ���ֽ��ϴ�.");
			}
		}
	}

	public String toString() {
		return "SCV";
	}
}

class Medic extends Unit implements Heal {
	Medic() {
		super(100, 100);
	}

	void heal(Heal h, int count) {
		if (h instanceof Unit) {
			Unit u = (Unit) h;
			if (u.hitPoint != u.MAX_HP) {
				if (u.MAX_HP - u.hitPoint < 5) {
					u.hitPoint = u.MAX_HP;
					System.out.println(this.toString() + "�� " + u.toString() + "[" + count + "]" + "�� ü���� +"
							+ (u.MAX_HP - u.hitPoint) + " ȸ���߽��ϴ�.");
				} else {
					u.hitPoint += 5;
					System.out.println(
							this.toString() + "�� " + u.toString() + "[" + count + "]" + "�� ü���� +5 ȸ���߽��ϴ�.");
				}
			} else {
				System.out.println("�̹� �������� ���� ���ֽ��ϴ�.");
			}
		}
	}

	public String toString() {
		return "Medic";
	}
}

public class Q48 {

	public static void main(String[] args) {
		Random r = new Random();

		Unit[] team_1 = new Unit[10];
		Unit[] team_2 = new Unit[10];
		SCV scv_1 = new SCV();
		SCV scv_2 = new SCV();
		Medic medic_1 = new Medic();
		Medic medic_2 = new Medic();

		for (int i = 0; i < 10; i++) {
			int random = r.nextInt(2);
			if (random == 0) {
				team_1[i] = new Tank();
			} else {
				team_1[i] = new Marine();
			}
		}

		for (int i = 0; i < 10; i++) {
			int random = r.nextInt(2);
			if (random == 0) {
				team_2[i] = new Tank();
			} else {
				team_2[i] = new Marine();
			}
		}

		int count = 1;
		int team_1_dead = 0;
		int team_2_dead = 0;

		while (true) {
			System.out.println("===" + count + "��° ��===========================");
			int random_heal = r.nextInt(10);
			int scv_or_medic = r.nextInt(2);
			int random_attack = r.nextInt(10);
			int random_damage = r.nextInt(10);

			// team_1 ��
			if (count % 2 == 1) {

				System.out.println("team_1�� ��");

				while (team_1[random_heal] == null) {
					random_heal = r.nextInt(10);
				}
				// scv�� �����
				if (scv_or_medic == 0) {
					if (team_1[random_heal] instanceof Tank) {
						Tank t = (Tank) team_1[random_heal];
						scv_1.repair(t, random_heal);
					} else {
						System.out.println(scv_1.toString() + "�� " + team_1[random_heal].toString() + "[" + random_heal
								+ "]" + "�� ������� �� �����ϴ�.");
					}
				}

				// medic�� ��
				else {
					if (team_1[random_heal] instanceof Marine) {
						Marine m = (Marine) team_1[random_heal];
						medic_1.heal(m, random_heal);
					} else {
						System.out.println(medic_1.toString() + "�� " + team_1[random_heal].toString() + "["
								+ random_heal + "]" + "�� ġ���� �� �����ϴ�.");
					}
				}

				while (team_1[random_attack] == null) {
					random_attack = r.nextInt(10);
				}
				while (team_2[random_damage] == null) {
					random_damage = r.nextInt(10);
				}

				// ����
				if (team_1[random_attack] instanceof Tank) {
					if (random_damage == 0) {
						team_1[random_attack].attack(team_2[random_damage], random_damage);
						if (team_2[random_damage + 1] != null) {
							team_1[random_attack].attack(team_2[random_damage + 1], random_damage + 1);
							if (team_2[random_damage + 1].hitPoint <= 0) {
								team_2[random_damage + 1] = null;
								team_2_dead++;
							}
						}
					} else if (random_damage == 9) {
						team_1[random_attack].attack(team_2[random_damage], random_damage);
						if (team_2[random_damage - 1] != null) {
							team_1[random_attack].attack(team_2[random_damage - 1], random_damage - 1);
							if (team_2[random_damage - 1].hitPoint <= 0) {
								team_2[random_damage - 1] = null;
								team_2_dead++;
							}
						}
					} else {
						team_1[random_attack].attack(team_2[random_damage], random_damage);
						if (team_2[random_damage - 1] != null) {
							team_1[random_attack].attack(team_2[random_damage - 1], random_damage - 1);
							if (team_2[random_damage - 1].hitPoint <= 0) {
								team_2[random_damage - 1] = null;
								team_2_dead++;
							}
						}
						if (team_2[random_damage + 1] != null) {
							team_1[random_attack].attack(team_2[random_damage + 1], random_damage + 1);
							if (team_2[random_damage + 1].hitPoint <= 0) {
								team_2[random_damage + 1] = null;
								team_2_dead++;
							}
						}
					}
				} else {
					team_1[random_attack].attack(team_2[random_damage], random_damage);
				}
				if (team_2[random_damage].hitPoint <= 0) {
					team_2[random_damage] = null;
					team_2_dead++;
				}

			}

			// team_2 ��
			else {

				System.out.println("team_2�� ��");

				while (team_2[random_heal] == null) {
					random_heal = r.nextInt(10);
				}
				// scv�� �����
				if (scv_or_medic == 0) {
					if (team_2[random_heal] instanceof Tank) {
						Tank t = (Tank) team_2[random_heal];
						scv_2.repair(t, random_heal);
					} else {
						System.out.println(scv_2.toString() + "�� " + team_2[random_heal].toString() + "[" + random_heal
								+ "]" + "�� ������� �� �����ϴ�.");
					}
				}

				// medic�� ��
				else {
					if (team_2[random_heal] instanceof Marine) {
						Marine m = (Marine) team_2[random_heal];
						medic_2.heal(m, random_heal);
					} else {
						System.out.println(medic_2.toString() + "�� " + team_2[random_heal].toString() + "["
								+ random_heal + "]" + "�� ġ���� �� �����ϴ�.");
					}
				}

				// ����
				while (team_2[random_attack] == null) {
					random_attack = r.nextInt(10);
				}
				while (team_1[random_damage] == null) {
					random_damage = r.nextInt(10);
				}
				if (team_2[random_attack] instanceof Tank) {
					if (random_damage == 0) {
						team_2[random_attack].attack(team_1[random_damage], random_damage);
						if (team_1[random_damage + 1] != null) {
							team_2[random_attack].attack(team_1[random_damage + 1], random_damage + 1);
							if (team_1[random_damage + 1].hitPoint <= 0) {
								team_1[random_damage + 1] = null;
								team_1_dead++;
							}
						}
					} else if (random_damage == 9) {
						team_2[random_attack].attack(team_1[random_damage], random_damage);
						if (team_1[random_damage - 1] != null) {
							team_2[random_attack].attack(team_1[random_damage - 1], random_damage - 1);
							if (team_1[random_damage - 1].hitPoint <= 0) {
								team_1[random_damage - 1] = null;
								team_1_dead++;
							}
						}
					} else {
						team_2[random_attack].attack(team_1[random_damage], random_damage);
						if (team_1[random_damage - 1] != null) {
							team_2[random_attack].attack(team_1[random_damage - 1], random_damage - 1);
							if (team_1[random_damage - 1].hitPoint <= 0) {
								team_1[random_damage - 1] = null;
								team_1_dead++;
							}
						}
						if (team_1[random_damage + 1] != null) {
							team_2[random_attack].attack(team_1[random_damage + 1], random_damage + 1);
							if (team_1[random_damage + 1].hitPoint <= 0) {
								team_1[random_damage + 1] = null;
								team_1_dead++;
							}
						}
					}
				} else {
					team_2[random_attack].attack(team_1[random_damage], random_damage);
				}
				if (team_1[random_damage].hitPoint <= 0) {
					team_1[random_damage] = null;
					team_1_dead++;
				}

			}

			if (team_1_dead == 10 || team_2_dead == 10) {
				if (team_1_dead == 10) {
					System.out.println("team_2�� �¸��߽��ϴ�.");
				} else {
					System.out.println("team_1�� �¸��߽��ϴ�.");
				}
				break;
			}
			System.out.print("team_1�� ü�� = ");
			for (int i = 0; i < 10; i++) {
				if (team_1[i] != null) {
					System.out.print(team_1[i].toString() + "[" + i + "] " + team_1[i].hitPoint + " / ");
				}
			}
			System.out.println();

			System.out.print("team_2�� ü�� = ");
			for (int i = 0; i < 10; i++) {
				if (team_2[i] != null) {
					System.out.print(team_2[i].toString() + "[" + i + "] " + team_2[i].hitPoint + " / ");
				}
			}
			System.out.println();

			count++;
		}

	}

}
