package com.java.filterTest;

public class HelloWorld {
    private String SayHello( String name){
        String msg = "my name is " + name + ",this is i us maven on the first time.";
        return msg;
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        String s = helloWorld.SayHello("joker");
        System.out.println(s);
    }
}
