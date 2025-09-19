package com.shubham.dine.flow.dine_flow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class MenuController {

    @GetMapping("/menu")
    public Map<String,String> displayMenu(){
        System.out.println("In Controller");
        Map<String,String> map = new HashMap<>();
        map.put("101","Pizza");
        map.put("102","Noodles");
        map.put("103","Fries");
        map.put("104","Burger");
        map.put("105","Garlic Butter naan");
        map.put("106","Dal Makhani");
        map.put("107","Chicken Curry");
        map.put("108","Mutton Curry");
        return map;
    }

}
