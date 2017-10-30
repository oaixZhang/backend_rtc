package com.rtc.bean;

import java.util.HashMap;
import java.util.Map;

public class MyResponse {
    public static Map<String, Object> sResponse(Object data){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","ok");
        map.put("data",data);
        return map;
    }
    public static Map<String, Object> fResponse(int code,String msg,Object data){
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        map.put("data",data);
        return map;
    }
}
