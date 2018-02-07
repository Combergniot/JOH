package com.gus.jobofferhunter.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Marcin on 2017-07-05.
 */

@Controller
public class LoginController {

    protected final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping({"/public", "/"} )
    public String publicPage(HttpServletRequest request) {
        System.out.println("Inside publicPage method!");
        System.out.println(request.getRequestURL()+"?"+request.getQueryString());
        return "welcome";
    }


}
