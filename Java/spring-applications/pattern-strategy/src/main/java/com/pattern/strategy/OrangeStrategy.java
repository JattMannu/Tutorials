package com.pattern.strategy;

import org.springframework.stereotype.Component;

@Component
public class OrangeStrategy implements Strategy {
    @Override
    public String execute() {
        return "Orange strategy has been called.";
    }
}
