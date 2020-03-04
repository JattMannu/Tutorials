package com.pattern;

import com.pattern.strategy.Strategy;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConsumerContext {

    private String name;
    private Strategy strategy;

    public String doAction(){
        String str = strategy.execute();
        return String.format("%s : %s" , name , str);
    }
}
