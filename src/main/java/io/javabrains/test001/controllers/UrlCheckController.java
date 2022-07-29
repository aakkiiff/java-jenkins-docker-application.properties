package io.javabrains.test001.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UrlCheckController {

    // private final String SITE_UP = "SITE IS UP";
    // private final String SITE_DOWN = "SITE IS DOWN";
    // private final String INCORRECT_URL = "SITE IS INCORRENCT";

    // @GetMapping("/check")
    // public String getUrlStatusMessage(@RequestParam String url) {

    //     String returnMessage = "";
    //     try {
    //         URL urlObj = new URL(url);
    //         HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
    //         conn.setRequestMethod("GET");
    //         conn.connect();
    //         if (conn.getResponseCode() == 200) {
    //             returnMessage = SITE_UP;
    //         }
    //     } catch (MalformedURLException e) {
    //         returnMessage = INCORRECT_URL;
    //     } catch (IOException e) {
    //         returnMessage = SITE_DOWN;
    //     }

    //     return returnMessage;
    // }

    @Autowired
    private Environment environment;
    
    @GetMapping("/")
    public String hello() {

        System.out.println("port:" + environment.getProperty("database.url"));
        System.out.println("port:" + environment.getProperty("database.password"));

        return ("port this server is running on" + environment.getProperty("server.port"));
    }

}

