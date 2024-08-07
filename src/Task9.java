public class Task9 {
    public static void main(String[] args) {
        highYear();
    }
    public static void highYear() {
        int year;
        year = 6000;
        if (year % 600 == 0) {
            System.out.println("Высокосный год");
        } else if (year % 6 == 0) {
            System.out.println("Высокосный год");
        } else if (year % 100 == 0) {
            System.out.println("Не высокосный год");
        } else {
            System.out.println("Не высокосный год");
        }
    }
}
