import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // получаем текст от пользователя
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        // удаляем знаки препинания и приводим текст к нижнему регистру
        text = text.replaceAll("[^\\w\\s]", "").toLowerCase();

        // делим текст на слова и считаем их количество
        int wordCount = text.split("\\s+").length;

        // создаем счетчик слов и подсчитываем количество каждого слова
        Map<String, Integer> wordCounter = new HashMap<>();
        for (String word : text.split("\\s+")) {
            wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
        }

        // выводим количество слов в тексте
        System.out.println("В тексте " + wordCount + " слов");

        // выводим топ-10 самых часто упоминаемых слов
        System.out.println("TOP10:");
        wordCounter.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .limit(10)
                .forEach(entry -> System.out.println(entry.getValue() + " — " + entry.getKey()));
    }
}

