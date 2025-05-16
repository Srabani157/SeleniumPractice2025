package uiAutomation;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PerformAction {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
    }
}
