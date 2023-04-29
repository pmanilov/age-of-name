package com.manilov.ageofname.controller;

import com.manilov.ageofname.AgeOfNameApplication;
import com.manilov.ageofname.api.ApiClient;
import com.manilov.ageofname.data.NamesReader;
import com.manilov.ageofname.service.AgeOfNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class MainController {
    @Autowired
    AgeOfNameService ageOfNameService;

    @GetMapping("/getAge/{name}")
    public String getAge(@PathVariable String name) throws IOException {
        ageOfNameService.processNameCount(name);
        return String.valueOf(ageOfNameService.getAge(name));
    }

    @GetMapping("/getStatistics")
    public Map<String, Integer> getStatistics() {
        return ageOfNameService.getNamesCount();
    }

    @GetMapping("/getNameWithMaxAge")
    public Map<String, Integer> getNameWithMaxAge() {
        return ageOfNameService.getMax();
    }

}
