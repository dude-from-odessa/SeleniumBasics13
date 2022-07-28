package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork1 {

    /*
HW
Go to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
click on leave
click on leave list
choose from "From calendar"
choose from "To calendar"
click only on cancelled and rejected checkboxes
uncheck Pending Approval
select IT support from DD
click search
quit the browser
     */
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        WebElement leaveButton = driver.findElement(By.xpath("//b[text()='Leave']"));
        leaveButton.click();
        WebElement leaveListButton = driver.findElement(By.linkText("Leave List"));
        leaveListButton.click();
        //---------------------------------
        WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
        fromCalendar.click();

        WebElement monthSelect = driver.findElement(By.className("ui-datepicker-month"));
        Select select = new Select(monthSelect);
        select.selectByVisibleText("Jul");

        WebElement yearSelect = driver.findElement(By.className("ui-datepicker-year"));
        select = new Select(yearSelect);
        select.selectByValue("2022");

        List<WebElement> tableDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for(WebElement element : tableDates){
              if(element.getText().equals("28")){
                  element.click();
                  break;
              }
        }
        //---------------------------------
        WebElement toCalendar = driver.findElement(By.id("calToDate"));
        toCalendar.click();

        WebElement monthSelect2 = driver.findElement(By.className("ui-datepicker-month"));
        select = new Select(monthSelect2);
        select.selectByVisibleText("Aug");

        WebElement yearSelect2 = driver.findElement(By.className("ui-datepicker-year"));
        select = new Select(yearSelect2);
        select.selectByValue("2022");
        tableDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for(WebElement element : tableDates){
            if(element.getText().equals("30")){
                element.click();
                break;
            }
        }
        //---------------------------------


        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for(WebElement check : checkBoxes) {
            if(check.isSelected()){
                check.click();
            }
        }
        List<WebElement> checkBoxesLabels = driver.findElements(By.xpath("//label[contains(@for, 'leaveList')]"));
        for(WebElement check : checkBoxesLabels){
            if(check.getText().toLowerCase().contains("cancelled") || check.getText().toLowerCase().contains("rejected")) {
                check.click();
            }
        }
        //---------------------------------

        WebElement subUnitDD = driver.findElement(By.id("leaveList_cmbSubunit"));
        select = new Select(subUnitDD);
        select.selectByVisibleText("IT Support");

        //---------------------------------

        WebElement serchButton = driver.findElement(By.name("btnSearch"));
        serchButton.click();

        //---------------------------------

        List<WebElement> resultSearchTable = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td"));
        for(WebElement result : resultSearchTable){
            System.out.println(result.getText());
        }

        //---------------------------------

        driver.quit();
    }
}
