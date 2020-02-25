package cn.leon.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {
    WebDriver driver;
    public BaseDriver(){
        System.setProperty("webdriver.chrome.driver", "D:\\plugin\\chromev74\\chromedriver.exe");
        driver = new ChromeDriver();
    }
}
