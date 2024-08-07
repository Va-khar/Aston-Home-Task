public class Task14 {
    public static int[] arrayLength(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void main(String[] args) {
        int len = 5;
        int initialValue = 10;
        int[] array = arrayLength(len, initialValue);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
