import com.sun.source.util.SourcePositions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



import java.awt.*;
import java.net.SocketOption;
import java.util.List;

public class Main {


    private static Label element;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        //*To Link
        driver.get("https://useinsider.com");

        //*Fullscreen
        driver.manage().window().maximize();

        //*To Company
        WebElement menuElement = driver.findElement(By.cssSelector("body > nav:nth-child(5) > div:nth-child(2) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(6) > a:nth-child(1)"));

        //*Click Company
        menuElement.click();

        //*To Careers
        WebElement subMenuElement = driver.findElement(By.cssSelector("body > nav:nth-child(5) > div:nth-child(2) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(6) > div:nth-child(2) > div:nth-child(2) > a:nth-child(2)"));

        //*Click Careers
        subMenuElement.click();

        Thread.sleep(5000);

        // *find Our Locations
        WebElement element = driver.findElement(By.xpath("//h3[@class='category-title-media ml-0']"));

        String expectedText = "Our Locations";
        String actualText = element.getText();

        if (actualText.contains(expectedText)) {
            System.out.println("Our Locations yazisi bulunmaktadir.");
        } else {
            System.out.println("Text bulunamadi.");
        }

        //*find SeeAllTeams
        WebElement teamsElement = driver.findElement(By.cssSelector(".btn.btn-outline-secondary.rounded.text-medium.mt-5.mx-auto.py-3.loadmore"));

        //*check clickability
        if (teamsElement.isEnabled()) {
            System.out.println("See All Teams tiklanabilir");
        } else {
            System.out.println("See All Teams tiklanamaz");
        }

        //*check lifeAtİnsider
        WebElement laiElement = driver.findElement(By.cssSelector("div[class='elementor-element elementor-element-21cea83 elementor-widget elementor-widget-heading'] h2[class='elementor-heading-title elementor-size-default']"));

        if (laiElement.isEnabled()) {
            System.out.println("Life at Insider goruldu.");
        } else {
            System.out.println("Life at Insider gorulmedi.");
        }
        //*popupaccept
        WebElement popup = driver.findElement(By.cssSelector("#wt-cli-accept-all-btn"));
        actions.moveToElement(popup).perform();
        actions.click().perform();


        Thread.sleep(2000);

        //*click SeeAllTeams
        WebElement element1 = driver.findElement(By.cssSelector(".btn.btn-outline-secondary.rounded.text-medium.mt-5.mx-auto.py-3.loadmore"));
        actions.moveToElement(teamsElement).perform();
        actions.click().perform();

        Thread.sleep(2000);
        //* click qacareers
        WebElement qaElement = driver.findElement(By.xpath("//h3[normalize-space()='Quality Assurance']"));
        actions.moveToElement(qaElement).perform();
        actions.click().perform();

        Thread.sleep(2000);
        WebElement qajobsElement = driver.findElement(By.cssSelector(".btn.btn-outline-secondary.rounded.text-medium.mt-2.py-3.px-lg-5.w-100.w-md-50"));
        qajobsElement.click();

        Thread.sleep(2000);
        WebElement locDropdown = driver.findElement(By.cssSelector("#select2-filter-by-location-container"));
        locDropdown.click();

        Thread.sleep(2000);
        WebElement titleElement = driver.findElement(By.xpath("//li[.='Istanbul, Turkey']"));
        titleElement.click();

        Thread.sleep(2000);
        WebElement viewRoleButton = driver.findElement(By.cssSelector(".btn.btn-navy.rounded.pt-2.pr-5.pb-2.pl-5[href='https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc']"));
        int initialWindowCount = driver.getWindowHandles().size();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", viewRoleButton);
        Thread.sleep(1000);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(windowHandle);
                break;

            }
        }
        Thread.sleep(1000);
        String expectedTitle = "Insider. - Senior Software Quality Assurance Engineer";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
        if (driver.getTitle().equals(expectedTitle)) {
            System.out.println("Check!");
        }

        driver.quit();

    }
}






