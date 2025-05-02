import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTable {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/web-table-element.php");
        driver.manage().window().maximize();
        List<WebElement> company_names = driver.findElements(By.xpath("//th[text()='Company']/ancestor::thead/following-sibling::tbody/tr/td[1]"));
        List<WebElement> table_header = driver.findElements(By.xpath("//tr/th"));
        int row_size = company_names.size();
        int i, j;
        boolean flag = false ;
        // Finding the Current Price Row
        for (j = 0; j < table_header.size(); j++) {
            if (table_header.get(j).getText().equals("Current Price (Rs)")) {

                break;
            }

        }

        // Finding the company name
        for (i = 0; i < row_size; i++) {
            if (company_names.get(i).getText().equals("Asian Paints Ltd.")) {
                flag = true;
                break;
            }


        }

        // Finding the current price for the company
        if(flag==true) {
            String current_price_xpath = String.format("//th[text()='Company']/ancestor::thead/following-sibling::tbody/tr[%s]/td[%s]", i, j);
            System.out.println("Current price for the company is : " + driver.findElement(By.xpath(current_price_xpath)).getText());
        }
        else
            System.out.println("Company not found");
        Thread.sleep(3000);
        driver.quit();

    }
}