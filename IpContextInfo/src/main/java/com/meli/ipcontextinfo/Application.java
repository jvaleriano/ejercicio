package com.meli.ipcontextinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Application {

    public Application() {
        System.setProperty("java.net.useSystemProxies", "true");        
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
