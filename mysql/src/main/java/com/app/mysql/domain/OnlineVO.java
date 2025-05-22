package com.app.mysql.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString(callSuper=true)
public class OnlineVO extends ProductVO {
    protected String marketName;
}
