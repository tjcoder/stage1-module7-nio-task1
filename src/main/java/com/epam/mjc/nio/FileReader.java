package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class FileReader {

    public Profile getDataFromFile(File file) {
        var profile = new Profile();
        try (var br = Files.newBufferedReader(file.toPath())) {
            String line;
            while ((line = br.readLine()) != null) {
                var keyValue = line.split(":", 2);
                var key = keyValue[0].trim();
                var val = keyValue[1].trim();

                switch (key) {
                    case "Name":
                        profile.setName(val);
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(val));
                        break;
                    case "Email":
                        profile.setEmail(val);
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(val));
                        break;
                    default:break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return profile;
    }
}
