package com.app.dependency.qulifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Laptop implements Computer {
    @Override
    public int getScreenWidth() {
        return 1280;
    }
}