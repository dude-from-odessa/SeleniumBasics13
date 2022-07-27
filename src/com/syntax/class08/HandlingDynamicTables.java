package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingDynamicTables {


    static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement username = driver.findElement(By.id("ctl00_MainContent_username")); // gettin webelement in return
        username.sendKeys("Tester"); // performing action on the specific element
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.className("button"));
        loginButton.click();
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));
        System.out.println(rows);
        for (int i = 1; i < rows.size(); i++) {
              String rowText = rows.get(i).getText();
            System.out.println(rowText);
            if(rowText.contains("FamilyAlbum")){
                List<WebElement> checkboxes  = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[1]"));
                System.out.println(checkboxes.size());
                checkboxes.get(i-1).click();
            }
        }

    }
}
