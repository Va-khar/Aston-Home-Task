public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Дон");
        Dog dog2 = new Dog("Басик");
        Cat cat1 = new Cat("Беляш");
        Cat cat2 = new Cat("Рыжик");

        dog1.run(250);
        dog1.swim(6);
        dog2.run(600);
        dog2.swim(10);

        cat1.run(150);
        cat1.swim(7);
        cat2.run(300);
        cat2.swim(100);

        System.out.println("Количество собак: " + Dog.getCount());
        System.out.println("Количество котов: " + Cat.getCount());
        System.out.println("Количество животных: " + Animal.getCount());
    }
}
