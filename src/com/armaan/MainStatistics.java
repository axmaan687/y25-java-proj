package com.armaan;
import java.util.*;

abstract class Statistics {
    double[] data;

    Statistics(double[] data) {
        this.data = data;
    }

    abstract double mean();
    abstract double median();
    abstract double mode();
}

class StatCalculator extends Statistics {

    StatCalculator(double[] data) {
        super(data);
    }

    double mean() {
        double sum = 0;
        for (double d : data) sum += d;
        return sum / data.length;
    }

    double median() {
        double[] arr = data.clone();
        Arrays.sort(arr);
        int mid = arr.length / 2;
        return (arr.length % 2 == 0) ? (arr[mid] + arr[mid - 1]) / 2 : arr[mid];
    }

    double mode() {
        HashMap<Double, Integer> freq = new HashMap<>();
        for (double d : data)
            freq.put(d, freq.getOrDefault(d, 0) + 1);

        double mode = data[0];
        int maxCount = 1;

        for (double key : freq.keySet()) {
            if (freq.get(key) > maxCount) {
                maxCount = freq.get(key);
                mode = key;
            }
        }
        return mode;
    }
}

public class MainStatistics {
    public static void main(String[] args) {
        double[] values = {1, 2, 2, 3, 4, 4, 4, 5};
        StatCalculator stats = new StatCalculator(values);

        System.out.println("Mean: " + stats.mean());
        System.out.println("Median: " + stats.median());
        System.out.println("Mode: " + stats.mode());
    }
}
