package cn.leon.login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class IoProperties{
    /**
     * 通过property和FileInputStream读取文件属性
     * @param key--输入键
     * @return--返回值
     * @throws IOException
     */
    public String  readValue(String key) throws IOException {
        //创建属性对象
        Properties file = new Properties();
        //创建输入流
        FileInputStream fis = null;
        {
            try {
                fis = new FileInputStream("src/properties.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        //将fis流中的所有的输数据加载到属性对象中
        file.load(fis);//属性中存在key = value的信息
        //关闭流
        fis.close();
        String value1 =  file.getProperty(key);
        return value1;
    }
}
