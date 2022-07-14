package com.syntax.class06.home_work;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork2 {

    public static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {

        /*
Go to https://syntaxprojects.com/javascript-alert-box-demo.php
click on each button and handle the alert accordingly
         */

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement buttonAlertBox = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
        buttonAlertBox.click();
        Alert alertBox = driver.switchTo().alert();
        alertBox.accept();

        WebElement buttonConfirmBox = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        buttonConfirmBox.click();
        Alert  confirmBox = driver.switchTo().alert();
        confirmBox.dismiss();
        System.out.println(driver.findElement(By.id("confirm-demo")).getText());

        buttonConfirmBox.click();
        confirmBox = driver.switchTo().alert();
        confirmBox.accept();
        System.out.println(driver.findElement(By.id("confirm-demo")).getText());

        // myPromptFunction()

        WebElement buttonPromtBox = driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        buttonPromtBox.click();
        Alert promtBox = driver.switchTo().alert();
        promtBox.sendKeys("Gennadiy");
        promtBox.accept();
        System.out.println(driver.findElement(By.id("prompt-demo")).getText());

        buttonPromtBox.click();
        promtBox=driver.switchTo().alert();
        System.out.println(promtBox.getText());
        promtBox.dismiss();
        System.out.println(driver.findElement(By.id("prompt-demo")).getText());
    }
}
