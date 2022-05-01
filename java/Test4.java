class Parent {
    public Parent() {
        System.out.print("A도 호출됨");
    }

    public void fn() {
        System.out.print("B");
    }

    public void fnA() {
        System.out.print("C");
    }
}

class Child extends Parent {
    public Child() {
        System.out.print("D");
    }

    public void fn() {
        System.out.print("E");
    }

    public void fnB() {
        System.out.print("F");
    }
}

public class Test4 {
    public static void main(String args[]) {
        Child c = new Child();
        c.fn();
        c.fnA();
    }
}