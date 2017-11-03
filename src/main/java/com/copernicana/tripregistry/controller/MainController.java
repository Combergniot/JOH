package com.copernicana.tripregistry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Kozanna
 */
@Controller
public class MainController {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("message", "message welcome huju");
        System.out.println("jestemy w loginie");
        return "loginForm";
    }

    @GetMapping("/start")
    public String getStartPage(Model model) {

        return "startPage";
    }
}
