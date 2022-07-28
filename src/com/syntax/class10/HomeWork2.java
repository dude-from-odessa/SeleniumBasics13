package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork2 {

    /*
Go to aa.com/homePage.do
select depart date
select return date
select destination
click on search
quit the browser
     */

    public static String url = "http://aa.com/homePage.do";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement departDate = driver.findElement(By.xpath("//input[@name='departDate']"));
        departDate.sendKeys("11/09/2022");
        WebElement returnDateDate = driver.findElement(By.xpath("//input[@name='returnDate']"));
        returnDateDate.sendKeys("12/15/2022");
        WebElement departureAirport = driver.findElement(By.xpath("(//input[@name='originAirport'])[1]"));
        departureAirport.sendKeys("Odesa");
        WebElement arrivalAirport = driver.findElement(By.xpath("(//input[@name='originAirport'])[1]"));
        arrivalAirport.sendKeys("New York");
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']"));
        searchButton.click();
        driver.quit();
    }
}
