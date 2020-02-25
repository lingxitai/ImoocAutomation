package cn.leon.login;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Listeners({TestNgListener.class})
public class LoginTest {

    @Test
    public void ss() throws Exception {
//        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        Login login =  new Login();


        String username = null;
        String password = null;

        Map<String,String> usermap = new HashMap<String,String>();//用户名参数化，放在map中
        usermap.put("13439131837","222333");
        usermap.put("1234444447777","333345465657676");//需要先输入上面那个，后面这个会报错
        for(String key:usermap.keySet()){
            username = key;
            password = usermap.get(key);
            if(("慕神1270506").equals(login.loginTest(username,password))){
                System.out.println("login successful");
            }else{
                System.out.println("login failed");
            }
        }
    }
}
