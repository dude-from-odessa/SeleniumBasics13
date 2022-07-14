package com.syntax.class05.home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomeWork2 {

    /*
        HW1
Go to facebook sign up page
Fill out the whole form
Click signup
     */

    public static String url = "https://www.facebook.com";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Button for New Account
        WebElement buttonNewAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
        buttonNewAccount.click();
        Thread.sleep(2000);

        // Drop Down menu for Months
        WebElement monthDD = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthDD);
        List<WebElement> optionsMonth = selectMonth.getOptions();
        System.out.println("Month DropDown has : " + optionsMonth.size() + " options");

        // Drop Down menu for Days
        WebElement dayDD = driver.findElement(By.id("day"));
        Select selectDay = new Select(dayDD);
        List<WebElement> optionsDay = selectMonth.getOptions();
        System.out.println("Month DropDown has : " + optionsDay.size() + " options");

        // Drop Down menu for Year
        WebElement yearDD = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDD);
        List<WebElement> optionsYear = selectYear.getOptions();
        System.out.println("Year DropDown has : " + optionsYear.size() + " options");

        // selecting the elements
        selectDay.selectByValue("3");
        selectMonth.selectByIndex(10);
        selectYear.selectByVisibleText("1985");
        Thread.sleep(2000);

        // radio button "Male"
        WebElement radioMale = driver.findElement(By.xpath("//label[text()='Male']/following-sibling::input"));
        radioMale.click();

        // First Name element
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Gennadiy");

        // Last Name element
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Babayev");

        // email element
        WebElement email = driver.findElement(By.xpath("//input[@aria-label='Mobile number or email']"));
        email.sendKeys("dude.from.odessa@gmail.com");

        // password element
        WebElement password = driver.findElement(By.xpath("//input[@data-type='password']"));
        password.sendKeys("12345678910Gena");

        // confirm email element
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        confirmPassword.sendKeys("dude.from.odessa@gmail.com");

        // sign up button
        WebElement buttonSignUp = driver.findElement(By.xpath("//button[@name='websubmit']"));
        buttonSignUp.click();


    }
}
