package main;

import java.util.Arrays;

public class TestCollectionFilter {
    public static void main(String[] args) {
        // Тест 1: Фильтр для строк (преобразование в верхний регистр)
        System.out.println("=== Тест 1: Строки ===");
        String[] words = {"hello", "world", "java", "programming"};
        Filter<String> upperCaseFilter = s -> s != null ? s.toUpperCase() : null;

        String[] upperCaseWords = CollectionFilter.filter(words, upperCaseFilter);
        System.out.println("Исходный: " + Arrays.toString(words));
        System.out.println("Результат: " + Arrays.toString(upperCaseWords));

        // Тест 2: Фильтр для чисел (умножение на 2)
        System.out.println("\n=== Тест 2: Числа ===");
        Integer[] numbers = {1, 2, 3, 4, 5};
        Filter<Integer> doubleFilter = n -> n != null ? n * 2 : null;

        Integer[] doubledNumbers = CollectionFilter.filter(numbers, doubleFilter);
        System.out.println("Исходный: " + Arrays.toString(numbers));
        System.out.println("Результат: " + Arrays.toString(doubledNumbers));

        // Тест 3: Фильтр с null значениями
        System.out.println("\n=== Тест 3: С null значениями ===");
        String[] wordsWithNull = {"hello", null, "world"};
        String[] filteredWithNull = CollectionFilter.filter(wordsWithNull, upperCaseFilter);
        System.out.println("Исходный: " + Arrays.toString(wordsWithNull));
        System.out.println("Результат: " + Arrays.toString(filteredWithNull));

        // Тест 4: Пустой массив
        System.out.println("\n=== Тест 4: Пустой массив ===");
        String[] emptyArray = {};
        String[] filteredEmpty = CollectionFilter.filter(emptyArray, upperCaseFilter);
        System.out.println("Исходный: " + Arrays.toString(emptyArray));
        System.out.println("Результат: " + Arrays.toString(filteredEmpty));

        // Тест 5: Проверка исключений
        System.out.println("\n=== Тест 5: Проверка исключений ===");
        try {
            CollectionFilter.filter(null, upperCaseFilter);
            System.out.println("ОШИБКА: Должно было выбросить исключение!");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Корректно выброшено исключение: " + e.getMessage());
        }

        try {
            CollectionFilter.filter(words, null);
            System.out.println("ОШИБКА: Должно было выбросить исключение!");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Корректно выброшено исключение: " + e.getMessage());
        }
    }
}