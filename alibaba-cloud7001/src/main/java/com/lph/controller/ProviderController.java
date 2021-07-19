package com.lph.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author lph
 **/
@RestController
public class ProviderController {

    @GetMapping("/provider")
    public String provider() {
        return "success";
    }

//    @GetMapping("/provider")
//    public String provider(HttpServletRequest request) {
//        return "success" + request.getHeader("x-token");
//    }



}
