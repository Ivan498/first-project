package main.java;

import java.util.Scanner;

public class Converter {
    int convertToKm(int steps){
         return (steps * 75) / 100000;
    }
    int convertStepsToKilocalories(int steps){
        return (steps * 50) / 1000;
    }
}


