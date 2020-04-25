package io.javabrains;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    //Value injection
    @Value("${my.greeting}")
    private String greetingMessage;

    @Value("${app.description}")
    private String appDescription;


    // 1
    @Value("This is a static Message")
    private String staticMsg;

    // 2
    @Value("${my.greeting}")
    private String fromApplicationProperties;

    // 3 : Default Value
    @Value("${my.greeting_missing: This is a default Value}")
    private String fromDefaultValue;


    // 4 :  List of values
    @Value("${my.list.values}")
    private List<String> myValueList;

    // 5 :  Key Values pair
    @Value("#{${my.keyValue}}")
    private Map<String,String> map;


    // curl localhost:8080/greeting
    @GetMapping("/greeting")
    public String greeting() {
        return greetingMessage;
    }

    // curl localhost:8080/app-desc
    @GetMapping("/app-desc")
    public String appDesc() {
        return appDescription;
    }


    // curl localhost:8080/printdefault
    @GetMapping("/printdefault")
    public String printdefault() {
        return fromDefaultValue;
    }

    // curl localhost:8080/printList
    @GetMapping("/printList")
    public String printList() {
        return "List: "+ myValueList;
    }

    // curl localhost:8080/printMap
    @GetMapping("/printMap")
    public String printMap() {
        return "Map: "+ this.map;
    }

}
