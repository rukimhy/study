package day24;
import java.util.ArrayList;
/* 이름, 전화번호, 주소 저장
 * 1.추가 - 이름, 전화번호, 주소를 입력받는다.
 * 2.삭제 - 이름을 입력받아 삭제한다.
 * 3.검색 - (1)전체 검색 (2)이름 검색
 * 이름 검색은 이름을 입력받아 이름이 있는 경우 정보를 출력하고 없으면 "없는 사람입니다." 출력
 * 4.종료
 */
import java.util.Scanner;

class Human{
	private String humanName;
	private String humanPhoneNumber;
	private String humanAddress;
	
	Human(String humanName, String humanPhoneNumber, String humanAddress){
		this.humanName = humanName;
		this.humanPhoneNumber = humanPhoneNumber;
		this.humanAddress = humanAddress;
	}
	
	public String getHumanName() {
		return humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}

	public String getHumanPhoneNumber() {
		return humanPhoneNumber;
	}

	public void setHumanPhoneNumber(String humanPhoneNumber) {
		this.humanPhoneNumber = humanPhoneNumber;
	}

	public String getHumanAddress() {
		return humanAddress;
	}

	public void setHumanAddress(String humanAddress) {
		this.humanAddress = humanAddress;
	}

	public String toString() {
		return "이름:"+humanName+" 전화번호:"+humanPhoneNumber+" 주소:"+humanAddress;
	}
}

class HumanArrayList {
	private ArrayList<Human> arrayList;
	
	public HumanArrayList() {
		arrayList = new ArrayList<Human>();
	}
	
	public void addHuman(Human human) {
		arrayList.add(human);
	}
	
	public boolean removeHuman(String humanName) {
		for(int i = 0; i< arrayList.size(); i++) {
			Human human = arrayList.get(i);
			String tempName = human.getHumanName();
			if(tempName.equals(humanName)) {
				arrayList.remove(i);
				return true;
			}
		}
		System.out.println("없는 이름입니다.");
		return false;
	}
	
	public void showAllHuman() {
		for(Human human : arrayList) {
			System.out.println(human);
		}
		System.out.println();
	}
	
	public boolean searchHuman(String humanName) {
		for(int i = 0; i< arrayList.size(); i++) {
			Human human = arrayList.get(i);
			String tempName = human.getHumanName();
			if(tempName.equals(humanName)) {
				System.out.println(human.toString());
				return true;
			}
		}
		System.out.println("없는 이름입니다.");
		return false;
	}
}

public class Q49 {

	public static void main(String[] args){
		HumanArrayList hal = new HumanArrayList();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("1.추가 2.삭제 3.검색 4.종료 : ");
			String select = scan.nextLine();
			
			if(select.equals("4") ) {
				System.out.println("종료되었습니다.");
				break;
			} else if(select.equals("1")) {
				System.out.print("이름 : ");
				String name = scan.nextLine();
				System.out.print("전화번호 : ");
				String phone = scan.nextLine();
				System.out.print("주소 :");
				String address = scan.nextLine();
			
				
				Human human = new Human(name, phone, address);
				hal.addHuman(human);
				System.out.println("추가되었습니다.");
				
			} else if(select.equals("2")) {
				System.out.print("이름을 입력해주세요 : ");
				String name = scan.nextLine();
				System.out.println();
				hal.removeHuman(name);
				System.out.println("삭제되었습니다.");
			} else if(select.equals("3")) {
				System.out.print("1.전체검색 2.이름검색 : ");
				String select_3 = scan.nextLine();
				
				if(select_3.equals("1")) {
					hal.showAllHuman();
				} else if(select_3.equals("2")) {
					System.out.print("이름을 입력해주세요 : ");
					String name = scan.nextLine();
					System.out.println();
					hal.searchHuman(name);
				} else {
					System.out.println("잘못된 입력입니다.");
				}
				
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

}
