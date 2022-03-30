public class Test {
    public static void main(String[] args) {
        int a = 3, b = 4, c = 3, d = 5;

        if ((a == 2 | a == c) & !(c > d) & (1 == b ^ c != d)) {
            a = b + c;
            System.out.println("no.1");
            if (7 == b ^ c != a) {
                System.out.println("no.3");
                System.out.println(c != a);
                System.out.println(a);
            } else {
                System.out.println("no.4");
                System.out.println(b);
            }
        } else {
            System.out.println("no.2");
            a = c + d;
            if (7 == c ^ d != a) {
                System.out.println(a);
            } else {
                System.out.println(d);
            }
        }
    }
}
