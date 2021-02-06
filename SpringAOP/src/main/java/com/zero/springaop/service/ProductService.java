package com.zero.springaop.service;

import com.zero.springaop.annotation.AdminOnly;
import com.zero.springaop.bean.Product;
import com.zero.springaop.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    AuthService authService;

    @AdminOnly
    public  void add(Product product){
        //authService.checkAccess();
        System.out.println("add the product");
    }

    @AdminOnly
    public  void delete(Long id){
        //authService.checkAccess();
        System.out.println("delete the product");
    }
}
