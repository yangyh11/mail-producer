package com.yangyh.mail.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yangyh
 * @create: 2019-09-04 00:30
 */
public class FastJsonConvertUtil {

    private static final SerializerFeature[] featuresWithNullValue = {SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty};

    /**
     * 将JSON字符串转换为实体对象
     * @param data  JSON字符串
     * @param clazz 转换对象
     * @return T
     */
    public static <T> T convertJSONToObject(String data, Class<T> clazz) {
        try {
            T t = JSON.parseObject(data, clazz);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将JSONObject对象转换为实体对象
     *
     * @param data  JSONObject对象
     * @param clazz 转换对象
     * @return T
     */
    public static <T> T convertJSONToObject(JSONObject data, Class<T> clazz) {
        try {
            T t = JSONObject.toJavaObject(data, clazz);
            return t;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    /**
     * 将JSON数组字符串转换为List集合对象
     *
     * @param data  JSON数组字符串
     * @param clazz 转换对象
     * @return List<T>集合对象
     */
    public static <T> List<T> convertJSONToArray(String data, Class<T> clazz) {
        try {
            List<T> list = JSON.parseArray(data, clazz);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将List<JSONObject>转换为List集合对象
     *
     * @param data  JSON对象List集合
     * @param clazz 转换对象
     * @return List<T>
     */
    public static <T> List<T> convertJSONToArray(List<JSONObject> data, Class<T> clazz) {
        try {
            List<T> list = new ArrayList<T>();
            data.forEach(jsonObject -> list.add(convertJSONToObject(jsonObject, clazz)));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将对象转为JSON字符串
     *
     * @param obj 任意对象
     * @return JSON字符串
     */
    public static String convertObjectToJSON(Object obj) {
        try {
            String text = JSON.toJSONString(obj);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将对象转为JSONObject对象
     *
     * @param obj 任意对象
     * @return JSONObject对象
     */
    public static JSONObject convertObjectToJSONObject(Object obj) {
        try {
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(obj);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 转换为JSON字符串过滤掉null
     *
     * @param obj
     * @return
     */
    public static String convertObjectToJSONWithNullValue(Object obj) {
        try {
            String text = JSON.toJSONString(obj, featuresWithNullValue);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
