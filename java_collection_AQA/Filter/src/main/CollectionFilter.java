package main;

import java.util.Arrays;

public class CollectionFilter {

    /**
     * Фильтрует массив, применяя функцию apply к каждому элементу
     * @param array исходный массив
     * @param filter реализация интерфейса Filter
     * @return новый массив с примененной функцией
     */
    public static <T> T[] filter(T[] array, Filter<T> filter) {
        // Проверка на null
        if (array == null || filter == null) {
            throw new IllegalArgumentException("Массив и фильтр не могут быть null");
        }

        // Создаем новый массив того же типа и длины
        @SuppressWarnings("unchecked")
        T[] result = (T[]) java.lang.reflect.Array.newInstance(
                array.getClass().getComponentType(),
                array.length
        );

        // Применяем функцию apply к каждому элементу
        for (int i = 0; i < array.length; i++) {
            result[i] = filter.apply(array[i]);
        }

        return result;
    }
}