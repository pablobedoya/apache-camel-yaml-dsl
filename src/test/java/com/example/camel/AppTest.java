package com.example.camel;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testAppMainMethod() throws Exception {
        // Testa o método main com duração de 1 segundo
        assertTimeout(Duration.ofSeconds(5), () -> {
            String[] args = {"-d", "1"};  // Duração de 1 segundo
            App.main(args);
        });
    }
}
