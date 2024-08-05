public class Task2 {
    public static void main(String[] args){
        checkSumSign();
    }
    public static void checkSumSign(){
        int a;
        int b;
        a = 58;
        b = 164;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная = " + sum);
        } else {
            System.out.println("Сумма отрицательная =" + sum);
        }
    }
}
