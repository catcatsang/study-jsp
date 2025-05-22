package com.app.mysql.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
@Getter

public class Period {
    protected String createdDate;
    protected String updatedDate;
}
