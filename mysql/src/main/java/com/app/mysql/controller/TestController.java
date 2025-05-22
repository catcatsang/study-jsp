package com.app.mysql.controller;

import com.app.mysql.domain.dto.ProductOnlineDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class TestController {
    @GetMapping("/test")
    public String test(HttpServletRequest request, Model model) {
//        log.info("{}", request.getAttribute("test"));
        return "test/test";
    }

    @GetMapping("/")
    public String index(HttpServletRequest request) {
//        log.info("{}", request.getAttribute("test"));
        return "index";
    }

    @GetMapping("/product")
    public void getProduct(ProductOnlineDTO productOnlineDTO){

    }
}

































