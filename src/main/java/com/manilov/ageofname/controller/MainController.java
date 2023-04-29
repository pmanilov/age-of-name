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
public class MainController {
    @Autowired
    AgeOfNameService ageOfNameService;
    @RequestMapping ("/")
    public String mainPage(){
        return "forward:/frontend/src/app/app.component.html";
    }

    @GetMapping("/getAge/{name}")
    public String getAge(@PathVariable String name) throws IOException {
        ageOfNameService.processNameCount(name);
        return name+" : "+ageOfNameService.getAge(name);
    }
    @GetMapping("/getStatistics")
    public String getStatistics() {
        return ageOfNameService.getNamesCount().toString();
    }

    @GetMapping("/getNameWithMaxAge")
    public String getNameWithMaxAge() {
        return ageOfNameService.getMax().toString();
    }

}
