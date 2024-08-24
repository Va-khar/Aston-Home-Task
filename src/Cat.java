public class Cat extends Animal {
    private static int count = 0;
    private String name;
    private boolean isFull;

    public Cat(String name) {
        super();
        count++;
        this.name = name;
        this.isFull = false;
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

    public void eat(FoodBowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            this.isFull = true;
            System.out.println(name + " поел и теперь сыт");
        } else {
            System.out.println(name + " не смог поесть. Недостаточно еды в миске");
        }
    }

    public  boolean isFull() {
        return isFull;
    }

    public static int getCount() {
        return count;
    }

    public String toString() {
        return name;
    }
}
