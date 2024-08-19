public class EmployeeArray {
    private String surname;
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public EmployeeArray(String surname, String name, String position, String email, String phone, int salary, int age) {
        this.surname = surname;
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void Information() {
        System.out.println("Фамилия: " + surname + "\n" +
                "Имя: " + name + "\n" +
                "Должность: " + position + "\n" +
                "Email: " + email + "\n" +
                "Телефон: " + phone + "\n" +
                "Зарплата: " + salary + "\n" +
                "Возраст: " + age);
    }

    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public int getSalary() {
        return salary;
    }
    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        EmployeeArray[] person = new EmployeeArray[5];
        person[0] = new EmployeeArray("Ivanov","Ivan", "Engineer", "ivanov@email.ru", "89031450534", 3000, 27);
        person[1] = new EmployeeArray("Petrov","Peter", "Developer", "petrov@email.ru", "89031450538", 4000, 40);
        person[2] = new EmployeeArray("Kuzminov","Oleg", "Analyst", "kuzminov@email.ru", "89031650534", 2000, 25);
        person[3] = new EmployeeArray("Mirsky","Lev", "Engineer", "mirsky@email.ru", "89031650234", 3000, 20);
        person[4] = new EmployeeArray("Fedorov","Fedya", "Developer", "fedorov@email.ru", "89031950534", 4000, 31);
        for (int i = 0; i < person.length; i++) {
            person[i].getSurname();
            person[i].getName();
            person[i].getPosition();
            person[i].getEmail();
            person[i].getPhone();
            person[i].getSalary();
            person[i].getAge();
        }

        for (EmployeeArray person1 : person) {
            person1.Information();
        }
    }
}
