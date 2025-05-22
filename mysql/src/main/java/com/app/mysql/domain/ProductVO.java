package com.app.mysql.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString(callSuper=true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=true)
public class ProductVO extends Period {
    @EqualsAndHashCode.Include
    private long id;
    private String productName;
    private int productPrice;
    private int productStock;
}
