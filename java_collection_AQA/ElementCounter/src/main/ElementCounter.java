package main;

import java.util.*;
import java.util.stream.Collectors;

public class ElementCounter {

    // Для массивов
    public static <T> Map<T, Integer> countElements(T[] array) {
        Map<T, Integer> countMap = new HashMap<>();
        for (T element : array) {
            countMap.merge(element, 1, Integer::sum);
        }
        return countMap;
    }

    // Для коллекций
    public static <T> Map<T, Integer> countElements(Collection<T> collection) {
        Map<T, Integer> countMap = new HashMap<>();
        for (T element : collection) {
            countMap.merge(element, 1, Integer::sum);
        }
        return countMap;
    }

    // Stream версия для коллекций
    public static <T> Map<T, Long> countElementsStream(Collection<T> collection) {
        return collection.stream()
                .collect(Collectors.groupingBy(
                        element -> element,
                        Collectors.counting()
                ));
    }
}