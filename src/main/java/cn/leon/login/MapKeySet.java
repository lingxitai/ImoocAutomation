package cn.leon.login;

import java.util.*;

public class MapKeySet {
    public static void main(String[] args){
        /**
         * keySet()方式
         */
        Map<String,String> aa =  new HashMap<String,String>();
        aa.put("name","leon");
        aa.put("id","1234");
        aa.put("sex","nan");
        System.out.println(aa);
        System.out.println(aa.get("name"));
        System.out.println(aa.keySet());//key的集合[sex, name, id]

        System.out.println("遍历map的第一种：通过Map.KeySet遍历Key和value");
        for(String key:aa.keySet()){//先通过遍历KeySet(key),再用get（key)获得值
            System.out.println(key+":"+aa.get(key));
        }

        System.out.println("遍历map的第2种：通过Map.entrySet遍历Key和value");
        System.out.println("entrySet中存放的key和value配对关系的集合，推荐使用，尤其数据较大时");
        for(Map.Entry<String,String> bb : aa.entrySet()){//aa.entrySet()出来后是Map.Entry类型的，其中包含键值的配对关系
            //可以直接通过getKey和getValue获取
            System.out.println(bb.getKey()+bb.getValue());
        }

        System.out.println("遍历map的第3种：通过Map.entry使用iterator遍历Key和value");
        Iterator<Map.Entry<String,String>> ii = aa.entrySet().iterator();
        while(ii.hasNext()) {//aa.entrySet()出来后是Map.Entry类型的，其中包含键值的配对关系
            //可以直接通过getKey和getValue获取
            System.out.println(ii.next());//ii.next()得到aa.entrySet()，所以可以直接打印，也可以ii.next().getKey()和getValue()
        }

        System.out.println("遍历map的第4种：可以直接遍历值,key不可以");
        for(String ss :aa.values()){
            System.out.println(ss);
        }

        List<String> listt = new ArrayList<String>();
        listt.add("ddd");
        listt.add("eee");
        listt.add("rrr");
        Iterator<String> cc = listt.iterator();
        while(cc.hasNext()){
            System.out.println(cc.next());
        }

        Map<String,String> usermap = new HashMap<String,String>();//用户名参数化，放在map中
        usermap.put("13439131837","222333");
        usermap.put("123444444","333345465657676");
        for(String key:usermap.keySet()){
            String username = key;
            String password = usermap.get(key);
            System.out.println(username+password);
        }


    }
}
