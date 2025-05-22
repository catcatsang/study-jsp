package com.app.dependency.qulifier;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ComputerTests {



    @Autowired
    Computer computer;





    @Test
    public void testComputer() {
        log.info("computer {}", Desktop);

    }
    @Test
    public void testLaptop() {
        log.info("Laptop {}", Laptop);
    }
}
