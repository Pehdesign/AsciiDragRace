package com.company;

import java.util.Random;

public class Car {

    public int location = 0;
    private Random carRandom;
    public char carChar;

    public void Run() {
        carRandom = new Random();
        location = location + carRandom.nextInt(3);
        for(int i = 0; i < location; i++) {System.out.print(" ");}
        System.out.println(carChar);
    }

    public void SetCarChar(char znak)
    {
        this.carChar = znak;
    }
}
