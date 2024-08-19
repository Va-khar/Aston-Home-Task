public class EmloyeeMassive {
    private String surname;
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public EmloyeeMassive(String surname, String name, String position, String email, String phone, int salary, int age) {
        this.surname = surname;
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void Information(){
        System.out.println(
                "Фамилия: " + surname + "\n" +
                "Имя: " + name + "\n" +
                "Должность: " + position + "\n" +
                "Email: " + email + "\n" +
                "Зарплата: " + salary + "\n" +
                "Возраст: " + age);
        System.out.println();
    }

    public String toString() {
        return  "Employee{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
