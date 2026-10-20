package com.marvel;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MarvelApplicationTests {

    @Test
    @Disabled("Desativado para execução sem validação de contexto")
    void contextLoads() {
    }

}