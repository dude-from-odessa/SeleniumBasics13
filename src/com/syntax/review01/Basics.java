package com.syntax.review01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basics {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        /*

        // goto syntaxprojects.com
        driver.get("https://syntaxprojects.com/index.php");
        // click on "start Practicing"
        WebElement button1 = driver.findElement(By.linkText("Start Practising"));  // spaces gave the error
        button1.click();
        Thread.sleep(2000);
        WebElement button2 = driver.findElement(By.partialLinkText("Proceed"));
        button2.click();

         */
driver.get("https://syntaxprojects.com/basic-first-form-demo.php");
        WebElement textBox = driver.findElement(By.id("user-message"));
        textBox.sendKeys("abracadabra");

    }
}
