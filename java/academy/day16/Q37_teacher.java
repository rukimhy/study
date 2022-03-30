package day16;

import java.util.Scanner;

//buyer
class Buyer
{
	int money;

	int comindex =0;
	int airindex =0;
	int refindex =0;
	int aircindex =0;

	Computer[] coms = new Computer[10];
	Aircon[] air = new Aircon[10];
	Ref[] ref = new Ref[10];
	AirCleaner[] airc = new AirCleaner[10];

}
//computer
class Computer
{
	String manufacture;
	String cpu;
	int price;

	void use()
	{
		System.out.println("제조사가"+manufacture+"인"+cpu+"컴퓨터를 사용합니다.");
	}
}
//Aricon
class Aircon
{
	String manufacture;
	String kind;
	int price;

	void start()
	{
		System.out.println("제조사가 " + manufacture + "인 " + kind +"에어컨을 사용한다");
	}
}
//Ref
class Ref
{
	String manufacture;
	String door;
	String L;
	int price;
	void manage() 
	{
		System.out.println("제조사가 " + manufacture + "인 "+ door +"형 " + L + "냉장고가 식품을 관리한다");
	}
}
//AirCleaner
class AirCleaner
{
	String manufacture;
	int price;
	void start() 
	{
		System.out.println("제조사가 " + manufacture + "인 " + "에어컨이 공기를 깨끗하게 한다 ");
	}
}


public class Q37_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Computer[] comArr = new Computer[10];
		Aircon[] airconArr = new Aircon[10];
		Ref[] refArr = new Ref[10];
		AirCleaner[] airCleanerArr = new AirCleaner[10];

		for(int i = 0; i< 5; ++i)
		{
			comArr[i] = new Computer();
			comArr[i].manufacture = "Samsung";
			comArr[i].cpu = "i7";
			comArr[i].price = 200;
			airconArr[i] = new Aircon();
			airconArr[i].kind = "벽걸이";
			airconArr[i].manufacture = "Samsung";
			airconArr[i].price = 100;
			refArr[i] = new Ref();
			refArr[i].manufacture = "Samsung";
			refArr[i].door = "양문";
			refArr[i].L = "600L";
			refArr[i].price = 200;
			airCleanerArr[i] = new AirCleaner();
			airCleanerArr[i].manufacture = "LG";
			airCleanerArr[i].price = 80;
		}
		for(int i = 5; i<10; ++i)
		{
			comArr[i] = new Computer();
			comArr[i].manufacture = "LG";
			comArr[i].cpu = "i5";
			comArr[i].price = 150;
			airconArr[i] = new Aircon();
			airconArr[i].kind = "스탠드";
			airconArr[i].manufacture = "LG";
			airconArr[i].price = 250;
			refArr[i] = new Ref();
			refArr[i].manufacture = "LG";
			refArr[i].door = "4도어";
			refArr[i].L = "800L";
			refArr[i].price = 350;
			airCleanerArr[i] = new AirCleaner();
			airCleanerArr[i].manufacture = "다이슨";
			airCleanerArr[i].price = 60;
		}


		Buyer[] b = new Buyer[3];

		for(int i =0;i<3;i++)
		{
			b[i] = new Buyer();
		}

		Scanner sc = new Scanner(System.in);

		System.out.println("1번 바이어 돈을 입력하세요 :");
		b[0].money = sc.nextInt();
		System.out.println("2번 바이어 돈을 입력하세요 :");
		b[1].money = sc.nextInt();
		System.out.println("3번 바이어 돈을 입력하세요 :");
		b[2].money = sc.nextInt();

		while(true)
		{
			for(int i =0;i<3;i++)
			{
				if(b[i].money >= 60)
				{
					//물건은 사는 게임 시작
					System.out.print((i+1)+"바이어 상품을 선택 해주세요 1. 컴퓨터 2.에어콘 3.냉장고 4.공기청정기 :");
					int select = sc.nextInt();
					if(select == 1)//컴퓨터
					{
						System.out.print("제조사 및 사양을 선택해주세요 1.삼성(i7) 2.LG(i5) : ");
						select = sc.nextInt();
						if(select == 1)
						{
							//1. 돈이 거지야
							b[i].money -= 200;
							if(b[i].money <0)
							{
								System.out.println("거지야 안녕!");
								b[i].money += 200; 
							}
							else
							{
								//2. 0~4까지 삼성
								int j = 0;
								while(comArr[j] == null)
								{
									j++;
								}
								if(j>=5)
								{
									System.out.println("재고가 없습니다.");
								}
								else
								{
									b[i].coms[b[i].comindex++] = comArr[j];
									comArr[j] = null;
								}

							}

						}
						else if(select == 2)
						{
							//1. 돈이 거지야
							// 5~9까지 LG
							//1. 돈이 거지야
							b[i].money -= 150;
							if(b[i].money <0)
							{
								System.out.println("거지야 안녕!");
								b[i].money += 150; 
							}
							else
							{
								//2. 0~4까지 삼성
								int j = 5;
								while(comArr[j] == null)
								{
									j++;
								}
								if(j>=10)
								{
									System.out.println("재고가 없습니다.");
								}
								else
								{
									//comindex++ => comindex = comindex +1
									b[i].coms[b[i].comindex++] = comArr[j];
									comArr[j] = null;
								}

							}
						}
						else
						{
							System.out.println("잘못된 입력입니다.");
						}
					}
					else if(select == 2) // 에어콘
					{
						System.out.print("제조사 및 사양을 선택해주세요 1.삼성(벽걸이형) 2.LG(스탠드형) : ");
						select = sc.nextInt();
						if(select == 1)
						{
							//1. 돈이 거지야
							b[i].money -= 100;
							if(b[i].money <0)
							{
								System.out.println("거지야 안녕!");
								b[i].money += 100; 
							}
							else
							{
								//2. 0~4까지 삼성
								int j = 0;
								while(airconArr[j] == null)
								{
									j++;
								}
								if(j>=5)
								{
									System.out.println("재고가 없습니다.");
								}
								else
								{
									b[i].air[b[i].airindex++] = airconArr[j];
									airconArr[j] = null;
								}

							}

						}
						else if(select == 2)
						{
							//1. 돈이 거지야
							// 5~9까지 LG
							//1. 돈이 거지야
							b[i].money -= 200;
							if(b[i].money <0)
							{
								System.out.println("거지야 안녕!");
								b[i].money += 200; 
							}
							else
							{
								//2. 0~4까지 삼성
								int j = 5;
								while(airconArr[j] == null)
								{
									j++;
								}
								if(j>=10)
								{
									System.out.println("재고가 없습니다.");
								}
								else
								{
									//comindex++ => comindex = comindex +1
									b[i].air[b[i].airindex++] = airconArr[j];
									airconArr[j] = null;
								}

							}
						}
						else
						{
							System.out.println("잘못된 입력입니다.");
						}
					}
					else if(select == 3) // 냉장고
					{
						System.out.print("제조사 및 사양을 선택해주세요 1.삼성(양문,600L) 2.LG(4도어, 800L) : ");
						select = sc.nextInt();
						if(select == 1)
						{
							//1. 돈이 거지야
							b[i].money -= 200;
							if(b[i].money <0)
							{
								System.out.println("거지야 안녕!");
								b[i].money += 200; 
							}
							else
							{
								//2. 0~4까지 삼성
								int j = 0;
								while(refArr[j] == null)
								{
									j++;
								}
								if(j>=5)
								{
									System.out.println("재고가 없습니다.");
								}
								else
								{
									b[i].ref[b[i].refindex++] = refArr[j];
									refArr[j] = null;
								}

							}

						}
						else if(select == 2)
						{
							//1. 돈이 거지야
							// 5~9까지 LG
							//1. 돈이 거지야
							b[i].money -= 350;
							if(b[i].money <0)
							{
								System.out.println("거지야 안녕!");
								b[i].money += 350; 
							}
							else
							{
								//2. 0~4까지 삼성
								int j = 5;
								while(refArr[j] == null)
								{
									j++;
								}
								if(j>=10)
								{
									System.out.println("재고가 없습니다.");
								}
								else
								{
									//comindex++ => comindex = comindex +1
									b[i].ref[b[i].refindex++] = refArr[j];
									refArr[j] = null;
								}

							}
						}
						else
						{
							System.out.println("잘못된 입력입니다.");
						}
					}
					else if(select == 4) // 공기청정기
					{
						System.out.print("제조사 및 사양을 선택해주세요 1.LG 2.다이슨 : ");
						select = sc.nextInt();
						if(select == 1)
						{
							//1. 돈이 거지야
							b[i].money -= 80;
							if(b[i].money <0)
							{
								System.out.println("거지야 안녕!");
								b[i].money += 80; 
							}
							else
							{
								//2. 0~4까지 삼성
								int j = 0;
								while(airCleanerArr[j] == null)
								{
									j++;
								}
								if(j>=5)
								{
									System.out.println("재고가 없습니다.");
								}
								else
								{
									b[i].airc[b[i].aircindex++] = airCleanerArr[j];
									airCleanerArr[j] = null;
								}

							}

						}
						else if(select == 2)
						{
							//1. 돈이 거지야
							// 5~9까지 LG
							//1. 돈이 거지야
							b[i].money -= 60;
							if(b[i].money <0)
							{
								System.out.println("거지야 안녕!");
								b[i].money += 60; 
							}
							else
							{
								//2. 0~4까지 삼성
								int j = 5;
								while(airCleanerArr[j] == null)
								{
									j++;
								}
								if(j>=10)
								{
									System.out.println("재고가 없습니다.");
								}
								else
								{
									//comindex++ => comindex = comindex +1
									b[i].airc[b[i].aircindex++] = airCleanerArr[j];
									airCleanerArr[j] = null;
								}

							}
						}
						else
						{
							System.out.println("잘못된 입력입니다.");
						}
					}
					else
					{
						System.out.println("잘못된 입력입니다.!!!!!!!!!!!!!");
					}
					for(int x = 0;x<3;x++)
					{
						System.out.println((x+1)+"Buyer의 현재 금액은 "+b[x].money+"입니다.");
					}
					
				}
				
			}
			if(b[0].money<60 && b[1].money<60 && b[2].money<60)
			{
				System.out.println("마켓 게임을 종료합니다.");
				break;
			}
		}

		for(int i =0;i<3;i++)
		{
			int k = 0;
			while(b[i].coms[k]!=null)
			{
				System.out.println((i+1)+"번 바이어는 ");
				b[i].coms[k].use();
				k++;
			}
			k = 0;
			while(b[i].air[k]!=null)
			{
				System.out.println((i+1)+"번 바이어는 ");
				b[i].air[k].start();;
				k++;
			}
			k = 0;
			while(b[i].ref[k]!=null)
			{
				System.out.println((i+1)+"번 바이어는 ");
				b[i].ref[k].manage();
				k++;
			}
			k = 0;
			while(b[i].airc[k]!=null)
			{
				System.out.println((i+1)+"번 바이어는 ");
				b[i].airc[k].start();
				k++;
			}
		}

	}
}
