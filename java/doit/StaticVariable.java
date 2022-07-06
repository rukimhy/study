public class StaticVariable {
    public static void main(String[] args) {
        StaticStudent.serialNum = 500;

        StaticStudent student1 = new StaticStudent();
        StaticStudent student2 = new StaticStudent();

        System.out.println(student1.studentID);
        System.out.println(student2.studentID);
    }
}

class StaticStudent {
    public static int serialNum = 1000;
    int studentID;

    public StaticStudent() {
        studentID = serialNum;
        serialNum++;
    }
}