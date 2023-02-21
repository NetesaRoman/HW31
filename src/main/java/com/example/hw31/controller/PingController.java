package com.example.hw31.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 *
 * @author Roman Netesa
 *
 */
@RestController
public class PingController {

    @GetMapping("/ping")
    public String ping(){
        return "OK";
    }


}
