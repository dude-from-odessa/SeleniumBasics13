package com.syntax.class04.home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork1 {
    public static void main(String[] args) {

        /*
        Open chrome browser
Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
Enter valid username and password (username - Admin, password - Hum@nhrm123)
Click on login button
Then verify Syntax Logo is displayed.
         */


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement userName = driver.findElement(By.cssSelector("input#txtUsername"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.cssSelector("input#txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement buttonLogin = driver.findElement(By.cssSelector("input[value = 'LOGIN']"));
        buttonLogin.click();
        WebElement syntaxLogo = driver.findElement(By.cssSelector("img[src $= 'syntax.png']"));
        boolean displayed = syntaxLogo.isDisplayed();
        if (displayed) {
            System.out.println("Syntax Logo is displayed");
        } else {
            System.out.println("Syntax Logo is not displayed");
        }
        driver.quit();
    }
}
