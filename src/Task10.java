public class Task10 {
    public static void main(String[] args) {
        changeNumbers();
    }
    public static void changeNumbers() {
        int[] array = {1,1,0,0,1,0,1,1,0,0};
        for (int i = 0; i < 10; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }
}
