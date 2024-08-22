public class Cat extends Animal {
    private static int count = 0;
    private String name;

    public Cat(String name) {
        super();
        count++;
        this.name = name;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " М");
        } else {
            System.out.println(name + " не может пробежать такую дистанцию");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }

    public static int getCount() {
        return count;
    }
}
