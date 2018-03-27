package com.tanoak.service.impl;

import com.tanoak.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String toString() {
        System.out.println("hello");
        return "asd";
    }
}
