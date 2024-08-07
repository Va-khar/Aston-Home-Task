public class Task11 {
    public static void main(String[] args) {
        recalNumber();
    }
    public static void recalNumber() {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        for (int i : array) {
            System.out.println(i);
        }
    }
}
