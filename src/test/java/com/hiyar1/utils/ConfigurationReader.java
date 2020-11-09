package com.hiyar1.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream in = new FileInputStream("configuration.properties")) {
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load properties file");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
