package com.zzti.zut.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JsonTest {
    public static JSONObject changeJsonObj(JSONObject jsonObj,Map<String, String> keyMap) {
        JSONObject resJson = new JSONObject();
        Set<String> keySet = jsonObj.keySet();
        for (String key : keySet) {
            String resKey = keyMap.get(key) == null ? key : keyMap.get(key);
            try {
                JSONObject jsonobj1 = jsonObj.getJSONObject(key);
                resJson.put(resKey, changeJsonObj(jsonobj1, keyMap));
            } catch (Exception e) {
                try {
                    JSONArray jsonArr = jsonObj.getJSONArray(key);
                    resJson.put(resKey, changeJsonArr(jsonArr, keyMap));
                } catch (Exception x) {
                    resJson.put(resKey, jsonObj.get(key));
                }
            }
        }
        return resJson;
    }

    public static JSONArray changeJsonArr(JSONArray jsonArr,Map<String, String> keyMap) {
        JSONArray resJson = new JSONArray();
        for (int i = 0; i < jsonArr.size(); i++) {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            resJson.add(changeJsonObj(jsonObj, keyMap));
        }
        return resJson;
    }

    public static void main(String[] args) {
        String jsonStr = "{\"user\":{\"name\":\"张三\",\"sex\":\"男\",\"hobby\":[{\"motion\":\"足球\",\"desc\":\"任性\"},{\"game\":\"英雄联盟\",\"desc\":\"就是这么任性\"}]}}";
        Map<String, String> keyMap = new HashMap<String, String>();
        keyMap.put("name", "XingMing");
        keyMap.put("user", "YongHu");
        keyMap.put("desc", "MiaoShu");
        JSONObject jsonObj = JsonTest.changeJsonObj(JSONObject.parseObject(jsonStr),keyMap);
        System.out.println("换值结果 》》 " + jsonObj.toString());
    }
}
