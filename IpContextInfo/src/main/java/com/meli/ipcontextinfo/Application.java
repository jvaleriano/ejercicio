package com.meli.ipcontextinfo;

import java.net.URL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Application {

    public Application() {

        // add the valid certificates 
        URL ul = Application.class.getClassLoader().getResource("cacerts");
        System.setProperty("javax.net.ssl.trustStore", ul.getPath());
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
