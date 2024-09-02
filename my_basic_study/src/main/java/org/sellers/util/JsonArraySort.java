package org.sellers.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

public class JsonArraySort {
    /**
     * 使jsonArray按指定顺序排序
     * 指定顺序从数据库种取得：leaderSorts
     *
     * @param jsonArray 需要排序的array
     */
    public JSONArray sort(JSONArray jsonArray) {
        HashMap<String, Integer> keyMap = new HashMap<>();
        jsonArray.sort((o1, o2) -> {
            // 处理不存在指定排序列表中的字符串
            if (keyMap.get(((JSONObject) o1).getString("userName")) == null || keyMap.get(((JSONObject) o2).getString("userName")) == null) {
                return 1;
            }
            return keyMap.get(((JSONObject) o1).getString("userName")).compareTo(keyMap.get(((JSONObject) o2).getString("userName")));
        });
        return jsonArray;
    }
}
