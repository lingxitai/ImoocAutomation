package cn.leon.login;

import org.testng.annotations.Test;

import java.io.IOException;

public class TakeScreenPicture {
    @Test
    public void takePictureTest() throws IOException {
        TakeScreenShot tss =  new TakeScreenShot();
//        System.out.println(tss.takePicture());
        tss.takePicture();
    }

}
