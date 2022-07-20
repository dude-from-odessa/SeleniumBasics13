package com.syntax.class07;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomeWork1 {

    /*
    Go to https://demoqa.com/browser-windows
click on New Tab and print the text from new tab in the console
click on New Window and print the text from new window in the console
click on New Window Message and print the text from new window in the console
Verify (compare) the titles for each page
Print out the title of the all pages
     */
    static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String mainHandle = driver.getWindowHandle();

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        iterator.next();
        String newTabHandle = iterator.next();
        String textNewTab = driver.switchTo().window(newTabHandle).findElement(By.id("sampleHeading")).getText();
        System.out.println(textNewTab);
        driver.close();
        driver.switchTo().window(mainHandle);
        Thread.sleep(2000);

        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        newWindowButton.click();
        allWindowHandles = driver.getWindowHandles();
        iterator=allWindowHandles.iterator();
        iterator.next();
        String newWindowHandle=iterator.next();
        String textNewWindow = driver.switchTo().window(newWindowHandle).findElement(By.id("sampleHeading")).getText();
        System.out.println(textNewWindow);
        driver.close();
        driver.switchTo().window(mainHandle);
        Thread.sleep(2000);

        WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
        newWindowMessage.click();
        allWindowHandles = driver.getWindowHandles();
        iterator=allWindowHandles.iterator();
        iterator.next();
        String newWindowMessageHandle=iterator.next();
        driver.close();

        // below code is not working, not able to identify the text and interact with window

        String textNewWindowMessage= driver.findElement(By.tagName("body")).getText();
        System.out.println(textNewWindowMessage);
        driver.close();


        }

    }

