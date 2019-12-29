package com.example.demo.handlermapping;

import com.example.demo.controller.MyController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class MyHandlerMapping extends SimpleUrlHandlerMapping {

    @Autowired
    MyController myController;

    @Autowired
    TimeBasedAccessInterceptor timeBasedAccessInterceptor;

    public MyHandlerMapping() {
        //Map<String, Object> urlMap = new HashMap<>();
        //urlMap.put("/", myController);
        //this.setUrlMap(urlMap);
        //this.setInterceptors(timeBasedAccessInterceptor);
    }
    //
//    @Override
//    public HandlerExecutionChain getHandler(HttpServletRequest httpServletRequest) throws Exception {
//        log.info(httpServletRequest.getMethod());
//        log.info(httpServletRequest.getAuthType());
//        log.info(httpServletRequest.getContextPath());
//        log.info(httpServletRequest.getPathInfo());
//        log.info(httpServletRequest.getPathTranslated());
//        log.info(httpServletRequest.getQueryString());
//        log.info(httpServletRequest.getRemoteUser());
//        return null;
//    }

}
