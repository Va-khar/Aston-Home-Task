public class Task5 {
    public static void main(String[] args) {
        sumCheck();
    }
    public static void sumCheck() {
        int a;
        int b;
        a = 4;
        b = 12;
        int sum = a + b;
        if (sum >= 10 && sum <=20) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
