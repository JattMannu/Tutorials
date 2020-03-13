package com.pattern.strategy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class OrangeStrategy implements Strategy {
    @Override
    public String execute() {
        return "Orange strategy has been called.";
    }
}
