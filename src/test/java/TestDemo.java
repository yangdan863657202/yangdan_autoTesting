

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestDemo {
    public WebDriver driver;
    public TestDemo(){
        //driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","D:/chromedriver/chromedriver.exe");
        driver =new ChromeDriver();
    }
    @Test
    public void SearchBaidu() {
        driver.get("http://www.baidu.com");
        driver.findElement(By.name("wd")).sendKeys("iquicktest");
        Assert.assertTrue(driver.getTitle().contains("百度"));
        System.out.println("hello");
       driver.quit();
    }
}