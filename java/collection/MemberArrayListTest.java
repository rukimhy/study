
public class MemberArrayListTest {

	public static void main(String[] args) {
		MemberArrayList memberArrayList = new MemberArrayList();
		Member memberLee = new Member(1001, "Carbin");
		Member memberSon = new Member(1002, "Mike");
		Member memberPark = new Member(1003, "Housing");
		Member memberHong = new Member(1004, "Nick");

		memberArrayList.addMember(memberLee);
		memberArrayList.addMember(memberSon);
		memberArrayList.addMember(memberPark);
		memberArrayList.addMember(memberHong);

		memberArrayList.showAllMember();

		memberArrayList.removeMember(memberHong.getMemberId());
		memberArrayList.showAllMember();
	}

}
