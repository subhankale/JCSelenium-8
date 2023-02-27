package com.juaracoding.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Tugasday14 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "c:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "https://formy-project.herokuapp.com/form";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");


        driver.findElement(By.id("first-name")).sendKeys("Juara");
        driver.findElement(By.id("last-name")).sendKeys("Coding");
        driver.findElement(By.id("job-title")).sendKeys("Programer");

        driver.findElement(By.id("radio-button-1")).click();
        driver.findElement(By.id("checkbox-1")).click();

        WebElement selectMenu =driver.findElement(By.id("select-menu"));
        Select option = new Select(selectMenu);
        option.selectByValue("2");
        System.out.println("Test Select 2-4");

        driver.findElement(By.id("datepicker")).sendKeys("02/27/2023");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);

        driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a")).click();
        System.out.println("Data berhasil disimpan");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        System.out.println("Delay 10 seconds");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Quit Browser");
    }
}