package com.inter;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {
    	Map<String, String> enviorntmentVars = System.getenv();
    	String hostName = enviorntmentVars.get("HOSTNAME");
    	return String.format("Hello, I am %s !", hostName);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}