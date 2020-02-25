package cn.leon.login;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLOutput;

@Listeners({TestNgListener.class})
public class IoPropertiesTest {
    @Test
    public void propertiesRead() throws IOException {
        IoProperties ip  = new IoProperties();
        String pp = ip.readValue("loginButton");
        if("js-signin-btn".equals(pp)){
            System.out.println("测试成功");
        }
    }
}
