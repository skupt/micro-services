package com.epam.javacc.microservices.businessservices.two.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
    @Autowired
    private GreetingClient greetingClient;

    @RequestMapping("/get-greeting")
    public String getGreeting(Model model) {
        model.addAttribute("greeting", greetingClient.greeting());
        return "greeting-view";
    }
}
