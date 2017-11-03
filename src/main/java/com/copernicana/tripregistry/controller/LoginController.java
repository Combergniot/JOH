package com.copernicana.tripregistry.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Marcin on 2017-07-05.
 */

@Controller
public class LoginController {

    @GetMapping({"/public", "/"} )
    public String publicPage(HttpServletRequest request) {
        System.out.println("Inside publicPage method!");
        System.out.println(request.getRequestURL()+"?"+request.getQueryString());
        return "welcome";
    }



//    @GetMapping("/admin")
//    public String adminPage(Map<String, Object> model) {
//        model.put("text", "AN ADMIN PAGE!");
//        return "page";
//    }


}
