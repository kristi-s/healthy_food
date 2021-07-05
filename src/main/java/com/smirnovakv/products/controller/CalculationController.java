package com.smirnovakv.products.controller;

import com.smirnovakv.products.dto.CategoryContainer;
import com.smirnovakv.products.dto.PeopleDto;
import com.smirnovakv.products.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculationController {

    private CalculationService calculationService;

    @Autowired
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/week/{woman}/{man}/{child}")
    public List<CategoryContainer> getProductsPerWeek(@PathVariable Integer woman,
                                                      @PathVariable Integer man,
                                                      @PathVariable Integer child) {
        return calculationService.getProductsPerWeek(new PeopleDto(woman, man, child));
    }

    @GetMapping("/day/{woman}/{man}/{child}")
    public List<CategoryContainer> getProductsPerDay(@PathVariable Integer woman,
                                                   @PathVariable Integer man,
                                                   @PathVariable Integer child) {
        return calculationService.getProductsPerDay(new PeopleDto(woman, man, child));
    }
}
