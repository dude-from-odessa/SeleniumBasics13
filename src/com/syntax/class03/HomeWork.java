package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {

    /*
    HW
Navigate to http://syntaxprojects.com
Click on start practicing
click on simple form demo
enter any text on first text box
click on show message
quit the browser
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://syntaxprojects.com");
        driver.findElement(By.xpath("//a[text()=' Start Practising ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text() = 'Check Box Demo']/preceding-sibling::a")).click();
        WebElement enterMessage = driver.findElement(By.xpath("//input[contains(@placeholder, 'Please')]"));
        enterMessage.sendKeys("Syntax");
        driver.findElement(By.xpath("//button[@onclick='showInput();']")).click();
        WebElement aEnterValue = driver.findElement(By.xpath("//label[@for='value1']/following-sibling::input"));
        aEnterValue.sendKeys("5");
        WebElement bEnterValue = driver.findElement(By.xpath("//label[@for='value2']/following-sibling::input"));
        bEnterValue.sendKeys("10");
        driver.findElement(By.xpath("//button[text() = 'Get Total']")).click();
        Thread.sleep(2000);
        driver.quit();

    }
}
