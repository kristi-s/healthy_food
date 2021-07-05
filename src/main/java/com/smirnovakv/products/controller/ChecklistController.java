package com.smirnovakv.products.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ChecklistController {

    @GetMapping("/checklist")
    public String showChecklist(@PathVariable Optional<String> name) {
        return String.join("\n",
                "Drink enough water for the day",
                "Eat enough vegetables for the day",
                "Eat a normal amount of vegetable protein for the day",
                "Eat fish at minimum twice for the week",
                "No fast food and gas water");
    }
}
