package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork {

    /*
    HW
navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
fill out the form
click on register
close the browser

navigate to fb.com
click on create new account
fill up all the textboxes
click on sign up button
close the pop up
close the browser
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
        driver.findElement(By.id("customer.firstName")).sendKeys("Teresa");
        driver.findElement(By.name("customer.lastName")).sendKeys("Swims");
        driver.findElement(By.id("customer.address.street")).sendKeys("331 Leisure Lane");
        driver.findElement(By.name("customer.address.city")).sendKeys("Ventura");
        driver.findElement(By.id("customer.address.state")).sendKeys("California");
        driver.findElement(By.name("customer.address.zipCode")).sendKeys("CA 93001");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("805-585-7896");
        driver.findElement((By.name("customer.ssn"))).sendKeys("537-88-4545");
        driver.findElement(By.id("customer.username")).sendKeys("forgottenname");
        driver.findElement(By.name("customer.password")).sendKeys("12345678Name");
        driver.findElement(By.id("repeatedPassword")).sendKeys("12345678Name");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        driver.quit();

        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get("https://www.fb.com/");
        driver1.manage().window().maximize();
        driver1.findElement(By.cssSelector("a[data-testid=open-registration-form-button]")).click();
        Thread.sleep(2000);
        driver1.findElement(By.name("firstname")).sendKeys("Teresa");
        driver1.findElement(By.name("lastname")).sendKeys("Swims");
        driver1.findElement(By.name("reg_email__")).sendKeys("805-585-7896");
        driver1.findElement(By.name("reg_passwd__")).sendKeys("12345678Name");
        driver1.findElement(By.name("birthday_month")).sendKeys("Sep");
        driver1.findElement(By.name("birthday_day")).sendKeys("1");
        driver1.findElement(By.name("birthday_year")).sendKeys("1951");
        driver1.findElement(By.cssSelector("input._8esa[value='1']")).click();
        Thread.sleep(2000);
        driver1.findElement(By.xpath("//button[text()='Sign Up']")).click();
        Thread.sleep(2000);
        driver1.findElement(By.cssSelector("img[src='https://static.xx.fbcdn.net/rsrc.php/v3/y2/r/__geKiQnSG-.png']")).click();
        Thread.sleep(2000);
        driver1.quit();

    }
}
