package com.example.camel;

import org.apache.camel.main.Main;

public class App {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        
        System.out.println("Starting Camel application...");
        main.run(args);
    }
}
