public class Dog extends Animal {
    private static int count = 0;
    private String name;

    public Dog(String name) {
        super();
        count++;
        this.name = name;

    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " M");
        } else {
            System.out.println(name + " не может пробежать такую дистанцию");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " М");
        } else {
            System.out.println(name + " не может проплыть такую дистанцию");
        }
    }

    public static int getCount() {
        return count;
    }
}
