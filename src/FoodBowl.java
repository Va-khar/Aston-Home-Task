public class FoodBowl {
    private int food;

    public FoodBowl(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int amount) {
        if (amount <= 0) {
            System.out.println("Количество еды должно быть больше нуля");
            return false;
        }
        if (food >= amount) {
            food -= amount;
            return true;
        }
        System.out.println("Недостаточно еды в миске. Осталось " + food + " еды");
        return false;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("Добавлено " + amount + " ед. еды в миску");
        } else {
            System.out.println("Количество добавляемой еды должно быть болье нуля");
        }
    }

    public int getFood() {
        return food;
    }
}
