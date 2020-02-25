package cn.leon.login;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Listeners({TestNgListener.class})
public class Login extends BaseDriver{
    public Login(){//Login的构造函数，初始化环境变量，用的谷歌浏览器的驱动
        System.setProperty("webdriver.chrome.driver", "D:\\plugin\\chromev74\\chromedriver.exe");
    }

    /**
     * 封装By
     * @param --by传递id,classname,name,xpath属性
     * @param --local，传递属性的值
     * @return
     */

    public By byStr(String by, String local){
        if(by.equals("id")){
            return By.id(local);
        }else if(by.equals("className")){
            return By.className(local);
        }else if(by.equals("name")){
            return By.name(local);
        }else{
            return By.xpath(local);
        }
    }




    public String loginTest(String username,String password) throws Exception {
//        String username = "13439131837";
//        String password = "222333";
//        String tangkuangclassName = "redrain-redPacketsIMG";
//        String tangkuangClose = "redrain-closeBtn";
//        String loginButton = "js-signin-btn";

        IoProperties ip =  new IoProperties();
//        String username = ip.readValue("username");读取配置文件的方式获得用户名
//        String password = ip.readValue("password");






        String tangkuangclassName = ip.readValue("tangkuangclassName");
        String tangkuangClose = ip.readValue("tangkuangClose");
        String loginButton = ip.readValue("loginButton");


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.imooc.com/");
        Thread.sleep(5000);
//        WebElement tankk =  driver.findElement(By.className("redrain-redPacketsIMG"));

        WebElement tankuang = driver.findElement(byStr("className",tangkuangclassName));
        if(tankuang.isDisplayed()){//如果有广告弹框，需要关闭
//            driver.findElement(By.className("redrain-closeBtn")).click();
            driver.findElement(byStr("className",tangkuangClose)).click();
        }

        driver.manage().window().maximize();//窗口最大化
        driver.findElement(byStr("id",loginButton)).click();//点击登录按钮
        Thread.sleep(1000);
        driver.findElement(By.className("active-title")).click();//点击登录键，确认是在登录框中

        driver.findElement(By.name("email")).sendKeys(username);//输入用户名
//      System.out.println(driver.findElement(By.name("email")).getAttribute("placeholder"));//调试用

        driver.findElement(By.name("password")).sendKeys(password);//输入密码


        WebElement signin =driver.findElement(By.id("auto-signin"));//找到七天内自动登录按钮
        if(signin.isSelected()){//判断是如果已经选中，就取消
            signin.click();
        }
        String bottondenglu = driver.findElement(By.className("moco-btn")).getAttribute("value");
//        System.out.println(bottondenglu);//调试用
        driver.findElement(By.className("moco-btn")).click();//点击登录按钮

//        driver.get("https://www.imooc.com/course/list");
        Thread.sleep(2000);//等待2秒

        WebElement userinfo =  driver.findElement(By.id("header-avator"));
        Actions action =  new Actions(driver);
        action.moveToElement(userinfo).perform();//在头像上悬停

//        TakeScreenShot tss =  new TakeScreenShot();//截图
////        System.out.println(tss.takePicture());
//        tss.takePicture();

        long ddate = System.currentTimeMillis();
        SimpleDateFormat geshi =  new SimpleDateFormat("yyyyMMdd-HHmmss");
        String currenttime = geshi.format(ddate);
        String path = currenttime+".jpg";//文件的名称


        /**
         * 截图的代码
         */
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//截图

        //获取当前路径
        String curPath = System.getProperty("user.dir");
        System.out.println(curPath);

        //拼接picturepath
        String picturepath = curPath + "/"+ path;

        FileUtils.copyFile(screen,new File(picturepath));






        return driver.findElement(By.className("name")).getText();

    }

}
