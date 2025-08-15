package com.kliv.spring.springprof.SOLID.liskovs;
class Bird {
    void fly() {
        System.out.println("Flying");
    }
}

class Sparrow extends Bird {
    // Inherits fly behavior
}

class Ostrich extends Bird {
    @Override
    void fly() {
        throw new UnsupportedOperationException("Ostrich can't fly");
    }
}