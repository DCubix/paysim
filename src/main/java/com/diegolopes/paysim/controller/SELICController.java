package com.diegolopes.paysim.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolopes.paysim.model.SELICTax;
import com.diegolopes.paysim.services.SELICTaxService;

@RestController
@RequestMapping("selic")
public class SELICController {
    
    @GetMapping("/current")
    public SELICTax getCurrent() {
        return SELICTaxService.current();
    }

    @GetMapping("/accumulated")
    public Map<String, Object> getAccumulated() {
        Map<String, Object> map = new HashMap<>();
        map.put("value", SELICTaxService.accumulated30Days());
        return map;
    }

}
