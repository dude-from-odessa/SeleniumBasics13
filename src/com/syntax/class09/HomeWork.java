package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork {

    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
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

        WebElement pimButton = driver.findElement(By.id("menu_pim_viewPimModule"));
        pimButton.click();

        WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
        addEmployeeButton.click();

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Adam");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Smith");
        WebElement empIdField = driver.findElement(By.id("employeeId"));
        String empId = empIdField.getAttribute("value");
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        saveButton.click();

        WebElement employeeListButton = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        employeeListButton.click();

        boolean employeeNotFound = true;

        while (employeeNotFound) {
            List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr")); // reinitialize all the element because the page gets refreshed
            for (int i = 0; i < tableRows.size(); i++) {
                String rowText = tableRows.get(i).getText();
                if (rowText.contains(empId)) { // compare the empId
                    employeeNotFound = false; // set the boolean as false
                    WebElement checkBox = driver.findElement(By.xpath("//table[@id = 'resultTable']/tbody/tr[" + i + "]/td[1]")); // identify the checkbox
                    checkBox.click();
                    // delete person we just added
                    WebElement deleteButton = driver.findElement(By.xpath("//input[@id='btnDelete']"));
                    deleteButton.click();
                }
                if (i == tableRows.size()-1 & tableRows.size() < 50) {
                    employeeNotFound = false;
                    WebElement idSearch = driver.findElement(By.name("empsearch[id]"));
                    idSearch.sendKeys(empId);
                    WebElement searchButton = driver.findElement(By.xpath("//input[@id='searchBtn']"));
                    searchButton.click();
                    tableRows = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr"));
                        if (tableRows.get(0).getText().contains(empId)){
                            WebElement checkBox = driver.findElement(By.xpath("//table[@id = 'resultTable']/tbody/tr/td")); // identify the checkbox
                            checkBox.click();
                            WebElement deleteButton = driver.findElement(By.xpath("//input[@id='btnDelete']"));
                            deleteButton.click();
                            WebElement confirmButton = driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']"));
                            confirmButton.click();
                            WebElement deleteText = driver.findElement(By.xpath("//td[text()='No Records Found']"));
                            System.out.println(deleteText.getText()+" : Employee ID was found and employee was deleted");
                        }
                }
            }
            if (employeeNotFound) {
                WebElement nextButton = driver.findElement(By.linkText("Next"));
                nextButton.click();
            }
        }
        driver.quit();
    }
}





