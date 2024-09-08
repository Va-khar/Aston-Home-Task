import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {
                "Кот", "Волк", "Медведь", "Голубь", "Лось",
                "Заяц", "Кукушка", "Лось", "Лось", "Волк",
                "Кабан", "Ворон", "Кабан", "Окунь", "Кукушка", "Кот", "Кот", "Медведь"
        };

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Уникальные слова: " + uniqueWords);

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            Integer count = wordCount.get(word);
            if (count == null) {
                wordCount.put(word, 1);
            } else {
                wordCount.put(word, count + 1);
            }
        }

        System.out.println("Сколько раз встречается каждое слово:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
