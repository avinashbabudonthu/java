package com.json;

import com.fasterxml.jackson.databind.util.JSONPObject;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JSONCreation {

    @Test
    public void test() {
        Map<String, String> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "[jack[jim]]");

        // JSONObject jsonObject = new JSONObject();
        // jsonObject.put("name", "[jack[jim]]");
        // jsonObject.set("name", String.valueOf("[jack[jim]]"));
        // System.out.println(jsonObject);

        // JSONObject jsonObject1 = JSONObject.fromString("[jack[jim]]");
        // System.out.println(jsonObject1);

        JSONObject jsonObject = JSONObject.fromMap(map);
        System.out.println(jsonObject);
    }

    @Test
    public void test2() {
        JSONPObject jsonpObject = new JSONPObject("name", "[jack[jim]]");
        System.out.println(jsonpObject);
    }

}
