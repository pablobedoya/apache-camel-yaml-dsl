package com.example.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.main.Main;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class AppTest extends CamelTestSupport {

    @Test
    public void testAppMainMethod() throws Exception {
        // Testa o método main com duração de 1 segundo
        assertTimeoutPreemptively(java.time.Duration.ofSeconds(5), () -> {
            String[] args = {"-d", "1"};  // Duração de 1 segundo
            App.main(args);
        });
    }

    @Test
    public void testCamelContextCreation() throws Exception {
        CamelContext context = createCamelContext();
        context.start();
        
        assertTrue(context.getStatus().isStarted());
        assertNotNull(context.getName());
        
        context.stop();
    }

    @Test
    public void testRouteLoading() throws Exception {
        CamelContext context = createCamelContext();
        context.getRegistry().bind("yamlRoutes", "classpath:routes/*.yaml");
        context.start();
        
        assertTrue(context.getStatus().isStarted());
        
        context.stop();
    }
}
