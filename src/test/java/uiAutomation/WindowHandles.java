package uiAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WindowHandles {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        String parentWindow = driver.getWindowHandle();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();
        Thread.sleep(5000);
        Set<String> handles = driver.getWindowHandles();
        for(String handle : handles){
            if(!handle.equals(parentWindow)){
                driver.switchTo().window(handle);
                driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("hii");
                driver.close();
                Thread.sleep(5000);
            }
        }
        driver.switchTo().window(parentWindow);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hello");
    }
}
