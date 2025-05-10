package com.itheima;

public class Outer {
    class Inner {}
    static class Inner2 {}

    public static void main(String[] args) {
//        Outer outer = new Outer();
//        Inner inner = outer.new Inner();
        Inner2 inner2 = new Inner2();


        System.out.println(inner2.toString());


    }
}
