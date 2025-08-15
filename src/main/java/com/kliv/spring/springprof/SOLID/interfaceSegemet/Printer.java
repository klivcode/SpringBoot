package com.kliv.spring.springprof.SOLID.interfaceSegemet;
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class MultiFunctionPrinter implements Printer, Scanner {
    public void print() {
        System.out.println("Printing...");
    }

    public void scan() {
        System.out.println("Scanning...");
    }
}

class SimplePrinter implements Printer {
    public void print() {
        System.out.println("Printing...");
    }
}