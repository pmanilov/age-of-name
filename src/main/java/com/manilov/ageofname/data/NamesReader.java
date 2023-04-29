package com.manilov.ageofname.data;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NamesReader {
    private Map<String, Integer> names;
    private String filepath;
    public NamesReader() {
        names = new HashMap<>();
        filepath = "src/main/java/com/manilov/ageofname/data/names.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split("_");
                if (parts.length == 2) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    names.put(name, age);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getNames() {
        return names;
    }

    public String getFilepath() {
        return filepath;
    }
}
