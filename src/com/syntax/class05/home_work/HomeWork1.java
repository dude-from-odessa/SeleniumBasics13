package com.syntax.class05.home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomeWork1 {

    /*
TC 1: Facebook dropdown verification
Open chrome browser
Go to "https://www.facebook.com"
click on create new account
Verify:
month dd has 12 month options
day dd has 31 day options
year dd has 115 year options
Select your date of birth
Quit browser
     */

    public static String url = "https://www.facebook.com";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        WebElement buttonNewAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
        buttonNewAccount.click();
        Thread.sleep(2000);

        WebElement monthDD = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthDD);
        List<WebElement> optionsMonth = selectMonth.getOptions();
        System.out.println("Month DropDown has : "+optionsMonth.size()+" options");

        WebElement dayDD = driver.findElement(By.id("day"));
        Select selectDay = new Select(dayDD);
        List<WebElement> optionsDay = selectMonth.getOptions();
        System.out.println("Month DropDown has : "+optionsDay.size()+" options");


        WebElement yearDD = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDD);
        List<WebElement> optionsYear = selectYear.getOptions();
        System.out.println("Year DropDown has : "+optionsYear.size()+" options");

        selectDay.selectByValue("3");
        selectMonth.selectByIndex(10);
        selectYear.selectByVisibleText("1985");
        Thread.sleep(2000);

        driver.quit();
    }
}
