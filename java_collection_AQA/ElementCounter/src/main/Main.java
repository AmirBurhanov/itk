package main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Тестирование с массивом строк
        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};
        Map<String, Integer> wordCount = ElementCounter.countElements(words);
        System.out.println("Count of words: " + wordCount);
        // Output: {orange=1, banana=2, apple=3}

        // Тестирование с массивом чисел
        Integer[] numbers = {1, 2, 3, 2, 1, 1, 4, 5, 1};
        Map<Integer, Integer> numberCount = ElementCounter.countElements(numbers);
        System.out.println("Count of numbers: " + numberCount);
        // Output: {1=4, 2=2, 3=1, 4=1, 5=1}

        // Тестирование с коллекцией
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "cherry");
        Map<String, Integer> fruitCount = ElementCounter.countElements(fruits);
        System.out.println("Count of fruits: " + fruitCount);
        // Output: {banana=1, apple=2, cherry=1}
    }
}