package uiAutomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Screenshot {
    static WebDriver driver = new ChromeDriver();
    @BeforeTest
    public void init(){
        driver.get("https://omayo.blogspot.com/");
    }
    @Test
    public void takeScreenshot(){
        String destiFile = "/Users/srabmukherjee/IdeaProjects/SeleniumPractice2025/src/test/resources/screenshots/screenshot.png";
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(file, new File(destiFile));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void selectSingleOptionFromDropdownMenu() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='drop1']"));
        Select select = new Select(dropdown);
        select.selectByIndex(2);
        Thread.sleep(2000);
    }
    @Test
    public void selectAllOptionFromDropdownMenu() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='drop1']"));
        Select select = new Select(dropdown);
        List<WebElement> getAllOptions = select.getOptions();
        for(WebElement option : getAllOptions){
           // System.out.println(option.getText());
            if(option.getText().equalsIgnoreCase("doc 2")){
                option.click();
                Thread.sleep(2000);
            }
        }
        Thread.sleep(2000);
    }
}
