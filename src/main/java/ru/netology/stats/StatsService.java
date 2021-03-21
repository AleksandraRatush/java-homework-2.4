package ru.netology.stats;

public class StatsService {

    public int agregate(int[] data) {
        int sum = 0;
        for (int monthData : data) {
            sum += monthData;
        }
        return sum;
    }

    public int average(int[] data) {
        return agregate(data) / data.length;
    }

    public int monthWithMaxSum(int[] data) {
        int max = 0;
        int month = 0;
        int maxMonth = 0;
        for (int monthData : data) {
            month++;
            if (monthData >= max) {
                max = monthData;
                maxMonth = month;
            }
        }
        return maxMonth;
    }

    public int monthWithMinSum(int[] data) {
        int min = Integer.MAX_VALUE;
        int month = 0;
        int minMonth = 0;
        for (int monthData : data) {
            month++;
            if (monthData <= min) {
                min = monthData;
                minMonth = month;
            }
        }
        return minMonth;
    }

    public int monthCountBelowAverage(int[] data) {
        int count = 0;
        int average = average(data);
        for (int monthData : data) {
            if (monthData < average) count++;
        }
        return count;
    }

    public int monthCountAboveAverage(int[] data) {
        int count = 0;
        int average = average(data);
        for (int monthData : data) {
            if (monthData > average) count++;
        }
        return count;
    }


}
