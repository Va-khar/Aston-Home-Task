public class Task12 {
    public static void main(String[] args) {
        multiSixMassiv();
    }
    public static void multiSixMassiv() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < 12; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }
}
