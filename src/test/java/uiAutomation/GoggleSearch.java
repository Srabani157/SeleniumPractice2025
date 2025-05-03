package uiAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GoggleSearch {

    public static void main(String[] args) throws InterruptedException {

        int count = 0,num;
        WebElement li;

        HashMap<Integer, String> hm = new HashMap<Integer, String>();
       // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.google.com");

        WebElement search_box = driver.findElement(By.xpath("//input[@name='q']"));
        search_box.sendKeys("Testing");
        //search_box.sendKeys(Keys.ENTER);

        List<WebElement> search_suggetsion = driver.findElements(By.xpath("//li[@role='presentation']/parent::ul[@role='listbox']/child::li"));
        Iterator<WebElement> itr = search_suggetsion.iterator();

        while (itr.hasNext()) {
            count++;
            li = itr.next();
            hm.put(count, li.getText());
            System.out.println(count + " " + li.getText());
            if(count == 7) {
                li.click();
                break;
            }


        }





        Thread.sleep(3000);
        //driver.quit();
    }
}
