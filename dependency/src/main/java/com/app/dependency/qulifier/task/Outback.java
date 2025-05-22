package com.app.dependency.qulifier.task;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("Vips")
@ToString
public class Outback implements Resturant {
    @Override
    public boolean foodname() {
        return false;
    }

    @Override
    public int price() {
        return 70;
    }
}
