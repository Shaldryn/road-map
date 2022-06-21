package com.dmdev.oop.lesson2;

public class Computer {
    private int ssd = 500;
    private int ram;

    Computer(int newSsd) {
        ssd = newSsd;
        ram = 999;
    }

    public Computer() {
        System.out.println("Я был создан");
    }

    protected Computer(int ssd, int newRam) {
        this.ssd = ssd;
        ram = newRam;
    }

    void load() {
        System.out.println("Я загрузился");
    }

//  [модификаторы] returnValue name([params])
    void printState() {
        System.out.println("Ssd: " + ssd);
        System.out.println("Ram: " + ram);
        System.out.println();
    }
}
