package com.example.demo.beans.xd;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("regular")
public class RegularWriter implements Writer {
    @Override
    public String Write(String S) {
        return S;
    }
}
