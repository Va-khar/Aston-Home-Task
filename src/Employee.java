public class Employee {
    private String surname;
    private String name;
    private String patronymic;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String surname, String name, String patronymic, String position, String email, String phone, int salary, int age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void Information() {
        System.out.println("Фамилия: " + surname + "\n" +
                "Имя: " + name + "\n" +
                "Отчество: " + patronymic + "\n" +
                "Должность: " + position + "\n" +
                "Email: " + email + "\n" +
                "Телефон: " + phone + "\n" +
                "Зарплата: " + salary + "\n" +
                "Возраст: " + age);
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(
                "Vakhnin",
                "Arkhip",
                "Stepanovich",
                "QA",
                "arkhip97@yandex.ru",
                "89774439972",
                50000,
                27);
        employee1.Information();
    }
}
