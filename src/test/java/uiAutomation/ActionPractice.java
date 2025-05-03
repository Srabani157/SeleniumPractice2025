package uiAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionPractice {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://omayo.blogspot.com/");
        WebElement blogs = driver.findElement(By.xpath("//a/span[@id='blogsmenu']"));
        WebElement seleniumByArun = driver.findElement(By.xpath("//span[text()='SeleniumByArun']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(blogs).perform();
        Thread.sleep(4000);
        actions.moveToElement(seleniumByArun).click().build().perform();


    }
}
