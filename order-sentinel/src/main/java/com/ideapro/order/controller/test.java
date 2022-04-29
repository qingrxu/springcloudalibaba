package com.ideapro.order.controller;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class test {

    public static void main(String[] args) {
        a(s -> System.out.println(s.toLowerCase()),s -> System.out.println(s.toUpperCase()));

    }

    public static void a (Consumer<String> b,Consumer<String> c){
        //b.accept(name);
        b.andThen(c).accept("name");
    }

    public static void b(Supplier<Integer> sup){
        a(s -> System.out.println(s.toLowerCase()),s -> System.out.println(s.toUpperCase()));
    }
}
