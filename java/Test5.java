class A {
    private int a;

    public A() {
        this.a = 1;
    }

    public A(int a) {
        this.a = a;
    }

    public void finalize() {
        System.out.println("class A Destructor");
    }

    public void getA() {
        System.out.println("class A's a : " + a);
    }
}

class B extends A {
    public void fnB() {
        System.out.println("class B");
    }
}

public class Test5 {
    public static void main(String[] args) {

        // Scanner example
        /*
         * String s;
         * System.out.print("input : ");
         * Scanner c = new Scanner(System.in);
         * s = c.nextLine();
         * System.out.println("output : "+s);
         */

        // Class example
        A a = new A(3);
        a.getA();
        a.finalize();

        // Inheritance
        B b = new B();
        b.getA();
        b.fnB();
        b.finalize();
    }
}