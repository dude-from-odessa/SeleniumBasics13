package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AdvancedWindowHandling {

    static String url = "http://syntaxprojects.com/window-popup-modal-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        String mianPageHandle = driver.getWindowHandle();
        System.out.println(mianPageHandle);
        WebElement igButton = driver.findElement(By.xpath("//a[@title='Follow @syntaxtech on Instagram']"));
        WebElement fbButton = driver.findElement(By.xpath("//a[@title='Follow @syntaxtech on Facebook']"));
        WebElement igAndFbButton = driver.findElement(By.xpath("//a[@title='Follow @syntaxtech']"));
        igButton.click();
        fbButton.click();
        igAndFbButton.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles.size());
        Iterator<String> it = allWindowHandles.iterator();
        while (it.hasNext()) {  // start iterating through the handles (tabs)
            String handle = it.next(); // get one handle (tab)
            if (!mianPageHandle.equals(handle)) { // set a condition where main page is not equal to the handle
                driver.switchTo().window(handle); // switch to that specific handle
                String title = driver.getTitle(); // get the title
                System.out.println(title);
                driver.close(); // close the tab
            }
        }
        driver.switchTo().window(mianPageHandle);
        igButton.click();
    }
}
