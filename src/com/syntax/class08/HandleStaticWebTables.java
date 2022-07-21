package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class HandleStaticWebTables {

    static String url = "http://syntaxprojects.com/table-search-filter-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        List<WebElement> rowData = driver.findElements(By.xpath("//table[@id = 'task-table']/tbody/tr"));    // Automatically return for us ArrayList
        System.out.println(rowData.size());

        Iterator<WebElement> it = rowData.iterator();
        while (it.hasNext()) {
            WebElement row = it.next();
            String rowText = row.getText();
            System.out.println(rowText);
        }

        System.out.println("------------------------------------");

        List<WebElement> colsData = driver.findElements(By.xpath("//table[@id = 'task-table']/thead/tr/th"));

        for(WebElement colData :colsData){
            String colText = colData.getText();
            System.out.println(colText);
        }
        System.out.println("------------------------------------");
        List<WebElement> colSecond = driver.findElements(By.xpath("//table[@id = 'task-table']/tbody/tr/td[2]"));
        for (WebElement col : colSecond){
            String colSecondText = col.getText();
            System.out.println(colSecondText);
        }
    }
}
