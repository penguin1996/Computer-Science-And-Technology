package com.zero.springaop;

import com.zero.springaop.bean.Product;
import com.zero.springaop.security.CurrentUserHolder;
import com.zero.springaop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@SpringBootTest
class SpringaopApplicationTests {

    @Autowired
    ProductService productService;

    @Test
    public void contextLoads() {
        CurrentUserHolder.set("admin");
        productService.add(new Product());
    }

    @Test
    public void excepitons() {
        CurrentUserHolder.set("user");
        productService.add(new Product());
    }

}
