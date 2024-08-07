public class Task13 {
    public static void main(String[] args) {
        massivVertical();
    }
    public static void massivVertical() {
        int n = 5;
        int[][] matrix = new int [n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
