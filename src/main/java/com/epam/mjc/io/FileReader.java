package com.epam.mjc.io;

import java.io.*;
import java.util.logging.Logger;

public class FileReader {

    public Profile getDataFromFile(File file) {

        String name = null;
        Integer age = 0;
        String email = null;
        Long phone = 0L;
        BufferedReader br = null;
        String st;
        try {
            br = new BufferedReader(new java.io.FileReader(file));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found");
        }
        int i = 0;
        while (i < 4) {
            try {
                for (i = 0; i <= 4; i++) {
                    if ((st = br.readLine()) == null)
                        break;
                    String result = st.split(" ")[1];
                    switch (i) {
                        case 0:
                            name = result;
                            break;
                        case 1:
                            age = Integer.valueOf(result);
                            break;
                        case 2:
                            email = result;
                            break;
                        case 3:
                            phone = Long.valueOf(result);
                            break;
                        default:
                            break;
                    }
                }
            } catch (IOException e) {
                e.getStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    Logger logA = Logger.getLogger("org.stepic.java.logging.ClassA");
                }
            }
        }
        Profile profile = new Profile(name, age, email, phone);
        return profile;
    }
}
