package org.example;

import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","G:\\WebDriver\\bin\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }
}