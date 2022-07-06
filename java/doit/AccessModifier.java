public class AccessModifier {
    public static void main(String[] args) {
        /* public - 외부 클래스 어디에서나 접근 가능 */
        /* private - 같은 클래스 내부에서만 접근 가능 */
        /* protected - 같은 패키지 내부와 상속 관계만 접근 가능 */
        /* default - 같은 패키지 내부에서만 접근 가능 */

        MyDate date1 = new MyDate(30, 2, 2000);
        System.out.println(date1.isVaild());
        MyDate date2 = new MyDate(2, 10, 2006);
        System.out.println(date2.isVaild());
    }
}

class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isVaild() {
        if (this.month == 2 && this.day > 28)
            return false;
        if (this.day > 31 || this.day < 1)
            return false;
        if (this.month > 12 || this.month < 1)
            return false;
        if (this.year < 0)
            return false;
        return true;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}