import static java.lang.invoke.MethodHandles.arrayLength;

public class Main {
    public static void main(String[] args) {
        Task1.printThreeWords();
        Task2.checkSumSign();
        Task3.printColor();
        Task4.compareNumbers();
        Task5.sumCheck();
        Task6.whichNumber();
        Task7.testNumberNeg();
        Task8.printString();
        Task9.highYear();
        Task10.changeNumbers();
        Task11.recalNumber();
        Task12.multiSixMassiv();
        Task13.massivVertical();
        int[] resultArray = Task14.arrayLength(5,10);
        for (int i = 0; i < resultArray.length; i++) {
            System.out.println(resultArray[i] + " ");
        }
    }
}

