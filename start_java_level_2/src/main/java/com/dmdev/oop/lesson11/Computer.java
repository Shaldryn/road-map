package com.dmdev.oop.lesson11;

public abstract class Computer implements Printable {

    private Ssd ssd;
    private Ram ram;

    {
        System.out.println("init block computer");
    }

    static {
        System.out.println("static block computer");
    }

    public Computer(Ssd ssd, Ram ram) {
        this.ssd = ssd;
        this.ram = ram;
    }

    public Computer() {
        System.out.println("Constructor computer");
    }

    public abstract void load();

    @Override
    public void print() {
        System.out.println("Ssd: " + ssd.getValue() + ", ram: " + ram.getValue());
    }

//    public void load() {
//        System.out.println("Я загрузился");
//    }

    public Ssd getSsd() {
        return ssd;
    }

    public Ram getRam() {
        return ram;
    }
}
