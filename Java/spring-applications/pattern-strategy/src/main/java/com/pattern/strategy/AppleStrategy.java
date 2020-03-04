package com.pattern.strategy;

import org.springframework.stereotype.Component;

@Component
public class AppleStrategy implements Strategy {
    @Override
    public String execute() {
        return "Apple strategy has been called.";
    }
}
