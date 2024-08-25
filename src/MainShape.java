public class MainShape {
    public static void main(String[] args) {
        Circle circle = new Circle(20, "Зеленый", "Красный");
        Rectangle rectangle = new Rectangle(20, 15, "Желтый", "Синий");
        Triangle triangle = new Triangle(10, 20, 30, "Белый", "Черный");

        System.out.println("Круг:");
        circle.printCharacteristics();

        System.out.println("\nПрямоугольник:");
        rectangle.printCharacteristics();

        System.out.println("\nТеугольник:");
        triangle.printCharacteristics();
    }
}
