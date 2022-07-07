package com.syntax.class04.home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork3 {

    public static void main(String[] args) {
        /*
        HW 2
HRMS Application Negative Login:
Open chrome browser
Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
Enter valid username
Leave password field empty
Click on login button
Verify error message with text "Password cannot be empty" is displayed.
         */

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement userName = driver.findElement(By.cssSelector("input#txtUsername"));
        userName.sendKeys("Admin");
        WebElement buttonLogin = driver.findElement(By.cssSelector("input[value = 'LOGIN']"));
        buttonLogin.click();
        WebElement errorMessage = driver.findElement(By.xpath("//span[text()='Password cannot be empty']"));
        if(errorMessage.isDisplayed()){
            System.out.println("Error message with text \"Password cannot be empty\" is displayed");
        } else {
            System.out.println("Error message with text \"Password cannot be empty\" is not displayed");
        }
        driver.quit();
    }
}
