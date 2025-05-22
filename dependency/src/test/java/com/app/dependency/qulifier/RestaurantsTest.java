package com.app.dependency.qulifier;


import com.app.dependency.qulifier.task.Outback;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RestaurantsTest {
    @Autowired
    public Outback outback;

    @Test
    public void Outback() {
        log.info("Outback {}", outback);
    }

}
