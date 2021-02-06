package com.zero.springaop.security;

import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class AuthService {

    public void checkAccess() {

        String user = CurrentUserHolder.get();
        if(!"admin".equals(user)){
           throw new NoSuchElementException();
        }
    }
}
