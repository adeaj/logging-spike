package com.nutmeg.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by adelaida on 24/04/2017.
 */
@RestController
@EnableAutoConfiguration
public class ExampleController {
    static final Logger logger = LoggerFactory.getLogger(ExampleController.class);
    public static final String SERVICE_NAME = "logging-spike";

    @RequestMapping("/logging")
    public void createLoggingJSON(){
        try {
            MDC.put("reqId", UUID.randomUUID().toString());
            MDC.put("service", SERVICE_NAME);
            logger.info("Logging Controller");
            throw new NullPointerException("message");
        }
        catch(NullPointerException e){
            logger.error("error", e);
        }
        finally {
            MDC.clear();
        }
    }
}

