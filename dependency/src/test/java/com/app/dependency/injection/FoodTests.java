package com.app.dependency.injection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class FoodTests {
    @Autowired
    private Food food;

    @Test
    public void foodTest(){
        log.info("food: {}", food);
    }

    @Test
    public void knifeTest(){
        log.info("knife: {}", food.getKnife());
    }
}
