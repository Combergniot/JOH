package com.gus.jobofferhunter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("message", "Pozdrawiamy!");
        System.out.println("jestemy w loginie");
        return "loginForm";
    }


    @GetMapping("/mainForm")
    public String getMainForm(Model model) {

        return "mainForm";
    }
}
