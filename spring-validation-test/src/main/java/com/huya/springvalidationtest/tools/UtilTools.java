package com.huya.springvalidationtest.tools;

import com.alibaba.fastjson.JSONObject;
import com.huya.springvalidationtest.exception.CodeMsg;
import com.huya.springvalidationtest.model.Result;

/**
 * @Author: licg
 * @Date: 2019/1/28
 * @Description：工具类
 */
public class UtilTools {
    public static String getJSONString(CodeMsg codeMsg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", codeMsg.getCode());
        jsonObject.put("msg", codeMsg.getMsg());
        return jsonObject.toJSONString();
    }

    public static String getJSONString(Result result) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", result.getCode());
        jsonObject.put("msg", result.getMsg());
        return jsonObject.toJSONString();
    }
}