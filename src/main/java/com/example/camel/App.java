package com.example.camel;

import org.apache.camel.main.Main;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        
        // Create custom WebSocket headers map
        Map<String, String> customHeaders = new HashMap<>();
        customHeaders.put("X-API-Version", "v1");
        customHeaders.put("User-Agent", "Apache-Camel/4.4.0");
        
        // Register the bean in Camel registry
        main.bind("myCustomHeaders", customHeaders);
        
        System.out.println("Starting Camel application...");
        main.run(args);
    }
}
