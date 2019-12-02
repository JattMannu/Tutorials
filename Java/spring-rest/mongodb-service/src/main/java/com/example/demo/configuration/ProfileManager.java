package com.example.demo.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProfileManager {

    @Autowired
    private Environment environment;

    public void getActiveProfiles(){
        for (String profileName: environment.getActiveProfiles()) {
            log.info("PROFILE NAME : {}",profileName);
        }
    }


}
