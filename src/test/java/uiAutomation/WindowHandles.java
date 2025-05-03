package uiAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WindowHandles {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        /*String current_window = driver.getWindowHandle();
        driver.findElement(By.xpath("//div/p/button[text()='New Browser Tab']")).click();
        Thread.sleep(5000);
        String source_link = "//p/span/a[contains(text(),'Decision Models')]";

        Set<String> all_windows = driver.getWindowHandles();
        Iterator<String> itr = all_windows.iterator();

        while(itr.hasNext()){
            if(current_window.equalsIgnoreCase(itr.next()))
            itr.next();;

        }*/


    }
}
