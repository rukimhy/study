package day25;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

class Contact{
	//이름, 전화번호, 주소 모두 String
	private String name;
	private String tel;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
    public String toString() {
		//주소가 아니라 문자열을 주려고 할때 
		//Object에 toString을 오버라이딩 한다.
        return name + "의 번호는 " + tel + "이고 주소는 " + address + "입니다.";
    }
	
}

class ContactArrayList
{
    private ArrayList<Contact> arrayList;

    public ContactArrayList() {
        arrayList = new ArrayList<Contact>();
    }

    //추가
    public void addContact(Contact contact) {
        arrayList.add(contact);
    }

    //삭제
    public void removeContact(String name) {
        for (int i = 0; i < arrayList.size(); i++) {
            Contact contact = arrayList.get(i);
            String tempName = contact.getName();
            if (tempName.equals(name)) {
                arrayList.remove(i);
                return;
            }
        }
        System.out.println(name + "가 존재하지않습니다.");
    }

    //전체출력
    public void showAllContact() {
        for (Contact contact : arrayList) {
        	//객체를 출력하면 전화번호부가 다 나오게 하려면?
            System.out.println(contact);
        }
        System.out.println();
    }
    
    //검색출력
    public void showSerchContact(String name)
    {
    	for(int i =0;i<arrayList.size();i++)
    	{
    		Contact temp = arrayList.get(i);
    		if(temp.getName().equals(name))
    		{
    			System.out.println(temp);
    			return;
    		}
    	}
    	System.out.println("검색하는 이름이 없습니다.");
    }
}



public class Q49_teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		ContactArrayList ca = new ContactArrayList();
		
		while(true)
		{
			System.out.print("1.추가 2. 삭제 3. 검색 4. 종료 :");
			int sel = sc.nextInt();
			if(sel == 1) // 추가
			{
				System.out.print("이름 : ");
				String name = sc.next();
				System.out.print("번호 : ");
				String number = sc.next();
				System.out.print("주소 : ");
				String address = sc.next();
				Contact c = new Contact();
				c.setName(name);
				c.setTel(number);
				c.setAddress(address);
				ca.addContact(c);
			}
			else if(sel == 2) // 삭제
			{
				System.out.print("이름 : ");
				String name = sc.next();
				ca.removeContact(name);
			}
			else if(sel == 3) // 검색
			{
				System.out.print("1. 전체검색 2. 이름검색");
				int twoSel = sc.nextInt();
				if(twoSel == 1)
				{
					ca.showAllContact();
				}
				else if(twoSel == 2)
				{
					System.out.print("이름 : ");
					String name = sc.next();
					ca.showSerchContact(name);
				}
				else
				{
					System.out.println("잘못된 입력입니다.");
				}
			}
			else if(sel == 4)
			{
				System.out.println("전화번호 프로그램을 종료합니다.");
				break;
			}
			else
			{
				System.out.println("잘못된 입력입니다.");
			}
		}
		
		
	}

}
