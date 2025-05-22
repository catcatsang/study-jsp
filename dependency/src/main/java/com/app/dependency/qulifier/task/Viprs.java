package com.app.dependency.qulifier.task;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Viprs implements Resturant {
    @Override
    public boolean foodname() {
        return false;
    }

    @Override
    public int price() {
        return 6000;
    }
}
