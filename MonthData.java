package main.java;

public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {// подсчёт статистики за месяц.
        for (int j = 0; j < days.length; j++) {
            System.out.println((j + 1) + " день:" + days[j]);
        }

    }

    int sumStepsFromMonth() {//подсчёт суммы шагов за месяц.
        int sum = 0;
        for (int j = 0; j < days.length; j++) {
            sum = sum + days[j];
        }
        return sum;
    }

    int maxSteps() {// максимальное количество шагов за месяц.
        int maxStep = 0;
        for (int j = 0; j < days.length; j++) {
            if (days[j] > maxStep) {
                maxStep = days[j];
            }
        }
        return maxStep;
    }

    int bestSeries(int goalByStepsPerDay) {//поиск максимальной серии.
        int nowSeries = 0;
        int finalSeries = 0;
        for (int j = 0; j < days.length; j++) {
            if (goalByStepsPerDay < days[j]) {
                nowSeries++;
            }
            else if (nowSeries > finalSeries) {
                finalSeries = nowSeries;
                nowSeries = 0;
                }

            }
        return finalSeries;
        }

    }

