package ru.netology.stats;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class StatsServiceTest {

    private int[] convertToArray(String input) {
        String[] array = input.replace("[", "")
                .replace("]", "")
                .split(",");
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.parseInt(array[i].trim());
        }
        return result;
    }

    @ParameterizedTest
    @CsvSource(value = {"'[8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18]', '180'"})
    void agregate(String data, int expected) {
        StatsService statsService = new StatsService();
        int actual = statsService.agregate(convertToArray(data));
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"'[8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18]', '15'"})
    void average(String data, int expected) {
        StatsService statsService = new StatsService();
        int actual = statsService.average(convertToArray(data));
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"'[8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18]', '8'"})
    void monthWithMaxSum(String data, int expected) {
        StatsService statsService = new StatsService();
        int actual = statsService.monthWithMaxSum(convertToArray(data));
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"'[8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18]', '9'"})
    void monthWithMinSum(String data, int expected) {
        StatsService statsService = new StatsService();
        int actual = statsService.monthWithMinSum(convertToArray(data));
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"'[8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18]', '5'"})
    void monthCountBelowAverage(String data, int expected) {
        StatsService statsService = new StatsService();
        int actual = statsService.monthCountBelowAverage(convertToArray(data));
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"'[8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18]', '5'"})
    void monthContAboveAverage(String data, int expected) {
        StatsService statsService = new StatsService();
        int actual = statsService.monthCountAboveAverage(convertToArray(data));
        assertEquals(actual, expected);
    }
}