package com.syntax.review02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        launch the website
        driver.get("https://demo.guru99.com/test/radio.html");
//        access the webElement radio button "option 3"
        WebElement option3 = driver.findElement(By.cssSelector("input[value='Option 3']"));
// check if the radio button is selected
        boolean state = option3.isSelected();
        System.out.println("The state of the radio button is " + state);
        // check if the radio button is displayed
        boolean displayed = option3.isDisplayed();
        System.out.println("Is the radio button is " + displayed);
        // check if the radio button is enabled
        boolean enabled = option3.isEnabled();
        System.out.println("Is the radio button enabled = can be clicked or not = "+enabled);
        option3.click();
        state = option3.isSelected();
        System.out.println("The state of the radio button is " + state);
    }
}
