package day15;

import java.util.Scanner;

class Computer{
	String maker;
	String type;
	int price;

	void output() {
		System.out.println("제조사가 "+maker+"이고, "+type+" CPU 컴퓨터를 사용한다.");
	}
}

class AirConditioner {
	String maker;
	String type;
	int price;

	void output() {
		System.out.println("제조사가 "+maker+"이고, "+type+" 에어컨을 사용한다.");
	}
}

class Refrigerator{
	String maker;
	String type;
	int liter;
	int price;

	void output() {
		System.out.println("제조사가 "+maker+"이고, "+type+", "+liter+"L 냉장고가 식품을 관리한다.");
	}
}

class AirCleaner{
	String maker;
	int price;

	void output() {
		System.out.println("제조사가 "+maker+"인 공기청정기가 공기를 깨끗하게 한다.");
	}
}

class Buyer{
	int money;
	Computer[] computer = new Computer[10];
	AirConditioner[] air_conditioner = new AirConditioner[10];
	Refrigerator[] refrigerator = new Refrigerator[10];
	AirCleaner[] air_cleaner = new AirCleaner[10];
}

public class Q37_computer {

	public static void main(String[] args) {
		/* 컴퓨터 - 제조사, CPU, 가격, 기능("제조사가 XXX이고, XXX CPU 컴퓨터를 사용한다.")
		 * 에어컨 - 제조사, 종류, 가격, 기능("제조사가 XXX이고, XX형 에어컨을 사용한다.")
		 * 냉장고 - 제조사, 문, 리터, 가격, 기능("제조사가 XXX이고, XX형, 몇L 냉장고가 식품을 관리한다.")
		 * 공기청정기 - 제조사, 가격, 기능("제조사가 XXX인 공기청정기가 공기를 깨끗하게 한다.")
		 *  
		 * 매장
		 * 컴퓨터 10개가 있다. 5개는 삼성, i7, 200원 / 5개는 LG, i5, 150원
		 * 에어컨 10대가 있다. 5개는 벽걸이, 삼성, 100원 / 5개는 스탠드, LG, 250원
		 * 냉장고 10대가 있다. 5개는 삼성, 양문, 600L, 200원 / 5개는 LG, 4도어, 800L, 350원
		 * 공기청정기 10대가 있다. 5개는 LG, 80원 / 5개는 다이슨, 60원
		 * 
		 * 바이어 - 돈, 10개 담는 컴퓨터, 에어컨, 냉장고, 공기청정기 배열
		 * 바이어는 총 3명이 있다. 바이어는 각각 돈을 입력받아서 돈을 가지고 있고 게임이 시작된다.
		 * 3명의 바이어는 1번부터 순차적으로 물건을 산다. 하지만 바이어가 돈이 60 미만이면 상품을 구매할 수 없기 때문에 그 다음 바이어로 넘어간다.
		 * 게임이 시작(첫화면) -> XXX 바이어 1.컴퓨터 2.에어컨 3.냉장고 4.공기청정기 : (숫자 입력)
		 * 숫자 입력하면 1.컴퓨터 -> 제조사 및 사양을 선택해주세요 1.삼성(i7) 2.LG(i5) : (숫자 입력)
		 * 				 2.에어컨 -> 제조사 및 사양을 선택해주세요 1.삼성(벽걸이형) 2.LG(스탠드형) : (숫자 입력)
		 * 			     3.냉장고 -> 제조사 및 사양을 선택해주세요 1.삼성(양문, 600L) 2.LG(4도어, 800L) : (숫자 입력)
		 *               4.공기청정기 -> 제조사 및 사양을 선택해주세요 1.LG 2.다이슨 : (숫자 입력)
		 * 바이어가 돈이 있고 제품이 있으면 바이어에 비어있는 배열에 담아주면 된다.
		 * 만약 돈이 부족하면 "돈이 부족합니다." 출력하고 다음 바이어의 첫화면으로 이동한다.
		 * 만약 매장에 제품이 없다면 "재고가 없습니다." 출력하고 다음 바이어의 첫화면으로 이동한다.
		 * 만약 바이어가 3000원이 있는데 컴퓨터 삼성것을 샀으면 바이어의 돈은 2800원이 남게 되어야 한다.
		 * 이렇게 3명의 바이어의 돈이 모두 60원 미만이 되면 프로그램을 종료한다.
		 * 프로그램이 종료된 이후 1~3번 바이어가 산 물품의 기능을 출력한다.
		 */
		Scanner scan = new Scanner(System.in);

		Computer[] samsung_computer = new Computer[5];
		AirConditioner[] samsung_air_conditioner = new AirConditioner[5];
		Refrigerator[] samsung_refrigerator = new Refrigerator[5];
		AirCleaner[] lg_air_cleaner = new AirCleaner[5];
		Computer[] lg_computer = new Computer[5];
		AirConditioner[] lg_air_conditioner = new AirConditioner[5];
		Refrigerator[] lg_refrigerator = new Refrigerator[5];
		AirCleaner[] daison_air_cleaner = new AirCleaner[5];

		for(int i=0; i<5; i++) {
			samsung_computer[i] = new Computer();
			samsung_air_conditioner[i] = new AirConditioner();
			samsung_refrigerator[i] = new Refrigerator();
			lg_air_cleaner[i] = new AirCleaner();
			samsung_computer[i].maker = "삼성";
			samsung_air_conditioner[i].maker = "삼성";
			samsung_refrigerator[i].maker = "삼성";
			lg_air_cleaner[i].maker = "LG";
			samsung_computer[i].price = 200;
			samsung_air_conditioner[i].price = 100;
			samsung_refrigerator[i].price = 200;
			lg_air_cleaner[i].price = 80;
			samsung_computer[i].type = "i7";
			samsung_air_conditioner[i].type = "벽걸이형";
			samsung_refrigerator[i].type = "양문형";
			samsung_refrigerator[i].liter = 600;
		}
		for(int i=0; i<5; i++) {
			lg_computer[i] = new Computer();
			lg_air_conditioner[i] = new AirConditioner();
			lg_refrigerator[i] = new Refrigerator();
			daison_air_cleaner[i] = new AirCleaner();
			lg_computer[i].maker = "LG";
			lg_air_conditioner[i].maker = "LG";
			lg_refrigerator[i].maker = "LG";
			daison_air_cleaner[i].maker = "다이슨";
			lg_computer[i].price = 150;
			lg_air_conditioner[i].price = 250;
			lg_refrigerator[i].price = 350;
			daison_air_cleaner[i].price = 60;
			lg_computer[i].type = "i5";
			lg_air_conditioner[i].type = "스탠드형";
			lg_refrigerator[i].type = "4도어형";
			lg_refrigerator[i].liter = 800;
		}

		// 바이어 객체 생성
		Buyer[] buyer = new Buyer[3];
		for(int i = 0; i<3; i++) {
			buyer[i] = new Buyer();
			System.out.print((i+1)+"번 buyer가 가질 금액을 입력하세요 : ");
			buyer[i].money = scan.nextInt();
		}

		//초기화
		int buyer_number = 0;

		int samsung_computer_count = 0;
		int samsung_aircon_count = 0;
		int samsung_refrigerator_count = 0;
		int lg_aircleaner_count = 0;

		int lg_computer_count = 0;
		int lg_aircon_count = 0;
		int lg_refrigerator_count = 0;
		int daison_aircleaner_count = 0;

		//게임시작 무한반복
		while(true) {
			if(buyer[buyer_number].money < 60) {
				buyer_number++;
				continue;
			} else {
				//바이어들이 가진 금액 출력
				System.out.println("-------------------");
				for(int i = 0; i<3; i++) {
					System.out.println((i+1)+"번 buyer가 가진 금액 : "+buyer[i].money);
				}
				System.out.println("-------------------");
			}

			//메인 첫화면
			System.out.print(buyer_number+1+"번 buyer > 1.컴퓨터 2.에어컨 3.냉장고 4.공기청정기 : ");
			int main_choice = scan.nextInt();

			//컴퓨터 선택
			if(main_choice == 1) {
				System.out.print("제조사 및 사양을 선택해주세요 1.삼성(i7) 2.LG(i5) : ");
				int computer_choice = scan.nextInt();

				//삼성 컴퓨터 선택
				if(computer_choice == 1) {
					if(samsung_computer_count == 5) {
						System.out.println("재고가 없습니다.");
					}  else {
						if(buyer[buyer_number].money-samsung_computer[samsung_computer_count].price >= 0) {
							buyer[buyer_number].money -= samsung_computer[samsung_computer_count].price;
							buyer[buyer_number].computer[samsung_computer_count] = new Computer();
							buyer[buyer_number].computer[samsung_computer_count] = samsung_computer[samsung_computer_count];
							samsung_computer[samsung_computer_count] = null;
							samsung_computer_count++;
							buyer_number++;
						} else {
							System.out.println("돈이 부족합니다.");
							buyer_number++;
						}
					}
				} 
				//LG 컴퓨터 선택
				else if(computer_choice == 2) {
					if(lg_computer_count == 5) {
						System.out.println("재고가 없습니다.");
					} else {
						if(buyer[buyer_number].money-lg_computer[lg_computer_count].price >= 0) {
							buyer[buyer_number].money -= lg_computer[lg_computer_count].price;
							buyer[buyer_number].computer[lg_computer_count+5] = new Computer();
							buyer[buyer_number].computer[lg_computer_count+5] = lg_computer[lg_computer_count]; 
							lg_computer[lg_computer_count] = null;
							lg_computer_count++;
							buyer_number++;
						} else {
							System.out.println("돈이 부족합니다.");
							buyer_number++;
						}
					}
				} 
				else {
					System.out.println("잘못된 입력입니다.");
					buyer_number++;
				}
			} 
			//에어컨 선택
			else if(main_choice == 2) {
				System.out.print("제조사 및 사양을 선택해주세요 1.삼성(벽걸이형) 2.LG(스탠드형) : ");
				int aircon_choice = scan.nextInt();

				//삼성 에어컨 선택
				if(aircon_choice == 1) {
					if(samsung_aircon_count == 5) {
						System.out.println("재고가 없습니다.");
					}
					else {
						if(buyer[buyer_number].money-samsung_air_conditioner[samsung_aircon_count].price >= 0) {
							buyer[buyer_number].money -= samsung_air_conditioner[samsung_aircon_count].price;
							buyer[buyer_number].air_conditioner[samsung_aircon_count] = new AirConditioner();
							buyer[buyer_number].air_conditioner[samsung_aircon_count] = samsung_air_conditioner[samsung_aircon_count]; 
							samsung_air_conditioner[samsung_aircon_count] = null;
							samsung_aircon_count++;
							buyer_number++;
						} else {
							System.out.println("돈이 부족합니다.");
							buyer_number++;
						}
					}
				} 
				//LG 에어컨 선택
				else if(aircon_choice == 2) {
					if(lg_aircon_count == 5) {
						System.out.println("재고가 없습니다.");
					}else {
						if(buyer[buyer_number].money-lg_air_conditioner[lg_aircon_count].price >= 0) {
							buyer[buyer_number].money -= lg_air_conditioner[lg_aircon_count].price;
							buyer[buyer_number].air_conditioner[lg_aircon_count+5] = new AirConditioner();
							buyer[buyer_number].air_conditioner[lg_aircon_count+5] = lg_air_conditioner[lg_aircon_count]; 
							lg_air_conditioner[lg_aircon_count] = null;
							lg_aircon_count++;
							buyer_number++;
						} else {
							System.out.println("돈이 부족합니다.");
							buyer_number++;
						}
					}
				} 
				else {
					System.out.println("잘못된 입력입니다.");
					buyer_number++;
				}

			} 
			//냉장고 선택
			else if(main_choice == 3) {
				System.out.print("제조사 및 사양을 선택해주세요 1.삼성(양문, 600L) 2.LG(4도어, 800L) : ");
				int refrigerator_choice = scan.nextInt();

				//삼성 냉장고 선택
				if(refrigerator_choice == 1) {
					if(samsung_refrigerator_count == 5) {
						System.out.println("재고가 없습니다.");
					} 
					else {
						if(buyer[buyer_number].money-samsung_refrigerator[samsung_refrigerator_count].price >= 0) {
							buyer[buyer_number].money -= samsung_refrigerator[samsung_refrigerator_count].price;
							buyer[buyer_number].refrigerator[samsung_refrigerator_count] = new Refrigerator();
							buyer[buyer_number].refrigerator[samsung_refrigerator_count] = samsung_refrigerator[samsung_refrigerator_count];
							samsung_refrigerator[samsung_refrigerator_count] = null;
							samsung_refrigerator_count++;
							buyer_number++;
						} else {
							System.out.println("돈이 부족합니다.");
							buyer_number++;
						}
					}
				}

				//LG 냉장고 선택
				else if(refrigerator_choice == 2) {
					if(lg_refrigerator_count == 5) {
						System.out.println("재고가 없습니다.");
					} else {
						if(buyer[buyer_number].money-lg_refrigerator[lg_refrigerator_count].price >= 0) {
							buyer[buyer_number].money -= lg_refrigerator[lg_refrigerator_count].price;
							buyer[buyer_number].refrigerator[lg_refrigerator_count+5] = new Refrigerator();
							buyer[buyer_number].refrigerator[lg_refrigerator_count+5] = lg_refrigerator[lg_refrigerator_count]; 
							lg_refrigerator[lg_refrigerator_count] = null;
							lg_refrigerator_count++;
							buyer_number++;
						} else {
							System.out.println("돈이 부족합니다.");
							buyer_number++;
						}
					} 
				}
				else {
					System.out.println("잘못된 입력입니다.");
					buyer_number++;
				}
			}
			//공기청정기 선택
			else if(main_choice == 4) {
				System.out.print("제조사 및 사양을 선택해주세요 1.LG 2.다이슨 : ");
				int aircleaner_choice = scan.nextInt();

				//LG 공기청정기 선택

				if(aircleaner_choice == 1) {
					if(lg_aircleaner_count == 5) {
						System.out.println("재고가 없습니다.");
					}else {
						if(buyer[buyer_number].money-lg_air_cleaner[lg_aircleaner_count].price >= 0) {
							buyer[buyer_number].money -= lg_air_cleaner[lg_aircleaner_count].price;
							buyer[buyer_number].air_cleaner[lg_aircleaner_count] = new AirCleaner();
							buyer[buyer_number].air_cleaner[lg_aircleaner_count] = lg_air_cleaner[lg_aircleaner_count];  
							lg_air_cleaner[lg_aircleaner_count] = null;
							lg_aircleaner_count++;
							buyer_number++;
						} else {
							System.out.println("돈이 부족합니다.");
							buyer_number++;
						}
					}
				}

				//다이슨 공기청정기 선택
				else if(aircleaner_choice == 2) {
					if(daison_aircleaner_count == 5) {
						System.out.println("재고가 없습니다.");
					}else {
						if(buyer[buyer_number].money-daison_air_cleaner[daison_aircleaner_count].price >= 0) {
							buyer[buyer_number].money -= daison_air_cleaner[daison_aircleaner_count].price;
							buyer[buyer_number].air_cleaner[daison_aircleaner_count+5] = new AirCleaner();
							buyer[buyer_number].air_cleaner[daison_aircleaner_count+5] = daison_air_cleaner[daison_aircleaner_count]; 
							daison_air_cleaner[daison_aircleaner_count] = null;
							daison_aircleaner_count++;
							buyer_number++;
						} else {
							System.out.println("돈이 부족합니다.");
							buyer_number++;
						}
					}
				} 
				else {
					System.out.println("잘못된 입력입니다.");
					buyer_number++;
				}
			} 
			//잘못된 입력
			else {
				System.out.println("잘못된 입력입니다.");
				buyer_number++;
			}

			// 초기화
			if(buyer_number == 3) buyer_number = 0;

			//결과출력
			if(buyer[0].money < 60 && buyer[1].money < 60 && buyer[2].money < 60) {
				for(int i = 0; i<3; i++) {
					for(int j = 0; j<10; j++) {
						if(buyer[i].computer[j] != null) {
							System.out.print((i+1)+"번 buyer는 ");
							buyer[i].computer[j].output();
						}
						if(buyer[i].air_conditioner[j] != null) {
							System.out.print((i+1)+"번 buyer는 ");
							buyer[i].air_conditioner[j].output();
						}
						if(buyer[i].refrigerator[j] != null) {
							System.out.print((i+1)+"번 buyer는 ");
							buyer[i].refrigerator[j].output();
						}
						if(buyer[i].air_cleaner[j] != null) {
							System.out.print((i+1)+"번 buyer는 ");
							buyer[i].air_cleaner[j].output();
						}
					}
				}
				break;
			}
		}

	}
}
