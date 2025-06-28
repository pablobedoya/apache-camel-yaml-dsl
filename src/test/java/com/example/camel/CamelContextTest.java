package com.example.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CamelContextTest extends CamelTestSupport {

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
