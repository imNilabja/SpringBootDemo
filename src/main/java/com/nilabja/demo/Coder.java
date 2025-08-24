package com.nilabja.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Coder {


    int id;
    String tech;
    @Autowired
    Laptop laptop;

    public void code(){
        laptop.compile();
    }


}
