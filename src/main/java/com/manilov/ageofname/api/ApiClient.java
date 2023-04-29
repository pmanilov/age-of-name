package com.manilov.ageofname.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class ApiClient {

    public static Integer getAgeForName(String name) throws IOException {
        URL url = new URL("https://api.agify.io/?name=" + name);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(content.toString());
        int age = node.get("age").asInt();
        return age;
       /* return String.valueOf(age);*/
    }

}
