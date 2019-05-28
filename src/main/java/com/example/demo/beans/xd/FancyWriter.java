package com.example.demo.beans.xd;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fancy")
public class FancyWriter implements Writer {

    @Override
    public String Write(String S) {
        return S+"fancy word";
    }
}
