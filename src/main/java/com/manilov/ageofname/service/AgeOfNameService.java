package com.manilov.ageofname.service;

import com.manilov.ageofname.api.ApiClient;
import com.manilov.ageofname.data.NamesReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AgeOfNameService {
    @Autowired
    NamesReader namesReader;
    @Autowired
    ApiClient apiClient;
    Map<String, Integer> namesCount= new HashMap<>();
    Map<String, Integer> namesAge= new HashMap<>();
    public void processNameCount(String name){
        if(namesCount.containsKey(name)){
            namesCount.put(name, namesCount.get(name) + 1);
        }
        else {
            namesCount.put(name, 1);
        }
    }
    public Map<String, Integer> getMax() {
        int max = 0;
        Map<String, Integer> names = namesReader.getNames();
        List<String> nameList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value == max) {
                nameList.add(key);
            }
            if(value > max) {
                max = value;
                nameList.clear();
                nameList.add(key);
            }
        }
        Map result = new HashMap<>();
        for(String name : nameList){
            result.put(name, max);
        }
        return result;
    }

    public Integer getAge(String name) throws IOException {
        Map<String, Integer> names = namesReader.getNames();
        if (names.containsKey(name)) {
            namesAge.put(name, names.get(name));
            return names.get(name);
        } else {
            Integer age = apiClient.getAgeForName(name);
            namesAge.put(name, age);
            return age;
        }
    }

    public Map<String, Integer> getNamesCount() {
        return namesCount;
    }

    public Map<String, Integer> getNamesAge() {
        return namesAge;
    }
}
