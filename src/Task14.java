public class Task14 {
    public static void main(String[] args) {
        arrayLength(int, int);
    }
    public static int [] arrayLength(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
