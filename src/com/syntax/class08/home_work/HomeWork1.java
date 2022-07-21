package com.syntax.class08.home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWork1 {

    /*
go to https://the-internet.herokuapp.com/dynamic_controls
click on checkbox and click on remove
verify the text
click on enable verify the textbox is enabled
enter text and click disable
verify the textbox is disabled
     */
    static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        //click on checkbox
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        //click on remove check box
        WebElement remove = driver.findElement(By.xpath("//button[text()='Remove']"));
        remove.click();
        //wait and verify "It's gone!"
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'gone')]")));
        String textMessage = driver.findElement(By.xpath("//p[contains(text(),'gone')]")).getText();
        System.out.println(textMessage);
        //click "Add" and wait then verify text
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
        addButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'back')]")));
        textMessage = driver.findElement(By.xpath("//p[contains(text(),'back')]")).getText();
        System.out.println(textMessage);
        //enable click and wait then verify text
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        System.out.println("Text Box is visible & enabled");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'enabled')]")));
        textMessage = driver.findElement(By.xpath("//p[contains(text(),'enabled')]")).getText();
        System.out.println(textMessage);
        //enter text and click disable
        WebElement textEntry = driver.findElement(By.xpath("//input[@type='text']"));
        textEntry.sendKeys("Batch 13 the Best!!!");
        WebElement disableButton = driver.findElement(By.xpath("//button[text()='Disable']"));
        disableButton.click();
        //verify the text box is disabled
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'disabled')]")));
        textMessage = driver.findElement(By.xpath("//p[contains(text(),'disabled')]")).getText();
        System.out.println(textMessage);
        if (!driver.findElement(By.xpath("//input[@type='text']")).isEnabled()) {

            System.out.println("Text Box is not enabled");
        } else {
            System.out.println("Text Box is still enabled");
        }
        driver.quit();
    }
}
