package com.syntax.class05.home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class HomeWork3 {

    /*
Go to ebay.com
get all the categories and print them in the console
select Computers/Tables & Networking
click on search
verify the header
     */

    public static String url = "https://www.ebay.com/";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        // finding the element for All Categories
        WebElement categories = driver.findElement(By.id("gh-cat"));
        // assign web element to Select class
        Select option = new Select(categories);
        // getOption method returns List of Elements with "option" tags & and storing it to List of Elements variable
        List<WebElement> options = option.getOptions();

        Iterator<WebElement> iterator = options.iterator();
        while (iterator.hasNext()) {
            WebElement ddOption = iterator.next();
            String optionText = ddOption.getText();
            System.out.println(optionText);
        }
        option.selectByVisibleText("Computers/Tablets & Networking");
        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Search']"));
        searchButton.click();
        Thread.sleep(10000);
        String title = driver.getTitle();
        System.out.println("==============================================================================");
        if(title.startsWith("Computers")){
            System.out.println("Title is verified - correct");
        }
    }
}
