public class MainShape {
    public static void main(String[] args) {
        Circle circle = new Circle(20, "Зеленый", "Красный");
        Rectangle rectangle = new Rectangle(20, 15, "Желтый", "Синий");
        Triangle triangle = new Triangle(10, 20, 30, "Белый", "Черный");

        circle.printCharacteristics();
        System.out.println("Круг:");

        rectangle.printCharacteristics();
        System.out.println("\nПрямоугольник:");

        triangle.printCharacteristics();
        System.out.println("\nТеугольник:");
    }
}
