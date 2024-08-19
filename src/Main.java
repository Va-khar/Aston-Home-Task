
public class Main {
    public static void main(String[] args) {
        EmloyeeOne emloyee1 = new EmloyeeOne(
                "Vakhnin",
                "Arkhip",
                "Stepanovich",
                "QA",
                "arkhip97@yandex.ru",
                "89774439972",
                50000,
                27);
        emloyee1.Information();
    }

    public static void main(String[] args) {
        EmloyeeMassive[] person = new EmloyeeMassive[5];
        person[0] = new EmloyeeMassive("Ivanov", "Ivan", "Engineer", "ivanov@email.ru", "89031450534", 2000, 25);
        person[1] = new EmloyeeMassive("Petrov", "Ivan", "Analyst", "petrov@email.ru", "89031480534", 3000, 28);
        person[2] = new EmloyeeMassive("Sobakov", "Peter", "Developer", "sobakov@email.ru", "89031454534", 5000, 30);
        person[3] = new EmloyeeMassive("Dostov", "Sergei", "DevOps", "dostov@email.ru", "89031410534", 2500, 24);
        person[4] = new EmloyeeMassive("Kusminov", "Oleg", "Engineer", "kusminov@email.ru", "89031450514", 2000, 26);
        for (int i = 0; i < person.length; i++) {
            person[i] = new EmloyeeMassive(
                    getsurName(),
                    getName(),
                    getPosition(),
                    getPhone(),
                    getSalary(),
                    getAge());
        }

        for (EmloyeeMassive employee2 : person) {
            employee2.Information();
        }
    }
}
