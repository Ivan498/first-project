package main.java;

import java.util.Scanner;

public class StepTracker {

    Converter converter = new Converter();
    int numberMonth ;
    Scanner scanner ;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    StepTracker(Scanner scan){//конструктор
        scanner = scan;
        for(int i = 0 ; i < monthToData.length; i++ ){
            monthToData[i] = new MonthData();
        }


    }
    void addNewNumberStepsPerDay(){
        System.out.println("Введите месяц от 1 до 12");
        int month = scanner.nextInt();
        if(month  < 1 | month > 12){
            System.out.println("Нет такого месяца");
            return;
        }
        System.out.println("Введите день от 1 до 30");
        int day = scanner.nextInt();
        if(day < 1 | day > 30){
            System.out.println("Нет такого дня");
            return;
        }
        System.out.println("Введите количество шагов");
        int step = scanner.nextInt();
        if(step < 0){
            System.out.println("Ошибка");
            return;
        }
        MonthData monthData = monthToData [month -1];
        monthData.days[day - 1] = step;


    }
    void changeStepGoal(){
        System.out.println("Введите число");
        int polz = scanner.nextInt();
        if(polz > 0){
            goalByStepsPerDay = polz;
        }
        else{
            System.out.println("Ошибка");//Поменять
        }
    }
    void printStatistic() {
        System.out.println("Введите число месяца");
        int month = scanner.nextInt(); // ввод и проверка номера месяца
        if(month < 1 | month > 12){
            System.out.println("Введите число месяца");
            return;
        }
        month = month - 1;

        MonthData monthData = monthToData[month];
        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println("Ваша статистика за этот месяц: ");
            monthData.printDaysAndStepsFromMonth();

        System.out.println("Вы прошли за этот месяц " + sumSteps + " шагов");
        System.out.println("Больше всего за этот месяц вы прошли " + monthData.maxSteps() + " шагов");
        System.out.println("В среднем вы прошли за этот месяц " + sumSteps / 30 + " шагов");
        System.out.println("За этот месяц вы прошли " + converter.convertToKm(sumSteps) + " км");
        System.out.println("За этот месяц вы сожгли " + converter.convertStepsToKilocalories(sumSteps) + " килокалории");
        System.out.println("Лучшая серия за этот месяц " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();

        }
    }




