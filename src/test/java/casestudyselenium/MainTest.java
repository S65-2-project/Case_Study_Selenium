package casestudyselenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainTest {

    @Test
    public void main() {

        System.setProperty("webdriver.gecko.driver", "/C:/Users/Woute/.gecko/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://fhict.nl/");

        driver.findElement(By.xpath("//*[@id=\"userNameInput\"]")).sendKeys("banaaniskrom");
        driver.findElement(By.xpath("//*[@id=\"passwordInput\"]")).sendKeys("banaanisvierkant");
        driver.findElement(By.xpath("//*[@id=\"kmsiInput\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"errorText\"]")).isDisplayed());

        driver.close();
    }
}