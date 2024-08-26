class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class ArrayExceptions {
    public static void checkAndSumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4х4, но имеет " + array.length + " строки");
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4х4, но содержит строку с " + row.length + " столбцы");
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные на (" + i + "," + j + "): " + array[i][j]);
                }
            }
        }
        System.out.println("Сумма массива равна: " + sum);
    }

    public static void main(String[] arfs) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] incorrectSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"10", "11", "12"}
        };

        String[][] incorrectDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"N", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            checkAndSumArray(correctArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkAndSumArray(incorrectSizeArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkAndSumArray(incorrectDataArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
