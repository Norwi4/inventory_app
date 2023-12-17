package com.avagyan.inventoryapp.settings;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abaev Evgeniy
 */
public interface Codable<S> {

    S getCode();

    /**
     * Выполняет поиск значения в перечислении по коду.
     *
     * @param codableSet класс - перечисление
     * @param code       код
     * @param <T>        перечисления
     * @return найденное значение перечилсения
     * @throws IllegalArgumentException если значение с данным кодом не найдено
     */
    static <T extends Enum<T> & Codable<S>, S> @NotNull T find(@NotNull Class<T> codableSet, @Nullable S code) {
        for (T codable : codableSet.getEnumConstants()) {
            if (codable.getCode().equals(code)) {
                return codable;
            }
        }
        throw new IllegalArgumentException(
                String.format("В перечислении %s не найдено значение для кода %s", codableSet.getName(), code));
    }


    /**
     * Выполняет поиск значения в перечислении по коду, если значение не найдено - то возвращает значение по умолчанию.
     *
     * @param codableSet   класс - перечисление
     * @param code         код
     * @param defaultValue значение по умолчанию
     * @param <T>          перечисления
     * @return найденное значение перечилсения
     */
    static <T extends Enum<T> & Codable<S>, S> @Nullable T find(
            @NotNull Class<T> codableSet,
            @Nullable S code,
            @Nullable T defaultValue
    ) {
        for (T codable : codableSet.getEnumConstants()) {
            if (codable.getCode().equals(code)) {
                return codable;
            }
        }
        return defaultValue;
    }

    /**
     * Преобразовать массив Codable к списку их кодов
     *
     * @param codables массив
     * @param <S> тип кода
     * @return список кодов
     */
    @SafeVarargs
    static <S> @NotNull List<S> toCodes(@NotNull Codable<S>... codables) {
        return Arrays.stream(codables)
                .map(Codable::getCode)
                .collect(Collectors.toList());
    }

}
