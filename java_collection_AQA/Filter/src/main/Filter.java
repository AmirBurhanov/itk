package main;

/** Интерфейс Filter с параметризованным методом apply */
interface Filter<T> {
    T apply(T o);
}