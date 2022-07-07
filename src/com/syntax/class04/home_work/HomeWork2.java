package com.syntax.class04.home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomeWork2 {
    public static void main(String[] args) {

        /*
        TC 1: Amazon link count:
Open chrome browser
Go to "https://www.amazon.com/"
Get all links
Get number of links that has text
Print to console only the links that has text
         */

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int sizeWithText=0;
        for(WebElement element : allLinks){
            String linkText = element.getText();
            String fullLink = element.getAttribute("href");
            if(!linkText.isEmpty() & fullLink!=null){
                sizeWithText++;
                System.out.println(linkText.replace("\n"," ")+" : "+fullLink);
            }
        }
        driver.quit();
        System.out.println("Number of links with text : "+sizeWithText);
    }
}
