package com.cydeo.utlities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {

        try {
            //2-Open file using FileInputStream(open file)
            FileInputStream file = new FileInputStream("configuration.Properties");
            //3-Load the "properties" object with "file"(load properties)
            properties.load(file);

            //close the file in the memory
            file.close();

        } catch (IOException e) {
            System.out.println("FILE not FOUND with GIVEN PATH!!!");
            e.printStackTrace();
        }
    }


    //create a utility method to use the object to read
    //4-Use "properties" object to read from the file(read properties)

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }


}
