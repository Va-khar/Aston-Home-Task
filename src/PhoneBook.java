import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        List<String> numbers = phoneBook.get(surname);
        if (numbers == null) {
            numbers = new ArrayList<>();
            phoneBook.put(surname, numbers);
        }
        numbers.add(phoneNumber);
    }

    public List<String> get(String surname) {
        List<String> numbers = phoneBook.get(surname);
        if (numbers == null) {
            return new ArrayList<>();
        }
        return numbers;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+79031450534");
        phoneBook.add("Петров", "+79056576712");
        phoneBook.add("Федоров","+79774518754");
        phoneBook.add("Круглов","+79058912475");
        phoneBook.add("Иванов","+79778231103");

        System.out.println("Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Петров: " + phoneBook.get("Петров"));
        System.out.println("Федоров: " + phoneBook.get("Федоров"));
        System.out.println("Круглов:" + phoneBook.get("Круглов"));
    }
}
