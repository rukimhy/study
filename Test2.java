public class Test2 {
    public static void main(String[] args) {
        int k = 10;
        int a = 3;

        switch (k++) {
            case 10:
                a += 2;
            case 11:
                a *= k;
            case 8:
                break;
        }
        System.out.println(a);
        System.out.println(k);
    }
}
