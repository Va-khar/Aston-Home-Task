public class Task14 {
    public static void main(String[] args) {
        int[] array = arrayLength(5, 10); // Create an array of length 5 with all elements initialized to 10
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static int[] arrayLength(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
