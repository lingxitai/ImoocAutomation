package cn.leon.login;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenShot extends BaseDriver{
    public void takePicture() throws IOException {
//        Date ddate = new Date(System.currentTimeMillis());
        long ddate = System.currentTimeMillis();
        SimpleDateFormat geshi =  new SimpleDateFormat("yyyyMMdd-HHmmss");
        String currenttime = geshi.format(ddate);
        String path = currenttime+".jpg";//文件的名称

//        Object driver = null;

        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//截图

        //获取当前路径
        String curPath = System.getProperty("user.dir");
        System.out.println(curPath);

        //拼接picturepath
        String picturepath = curPath + "/"+ path;

        FileUtils.copyFile(screen,new File(picturepath));


    }

}
