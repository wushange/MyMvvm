package com.connxun.morui.view.helper.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences工具类
 * Created by vondear on 2016/1/24.
 */

public class SPUtil {

    private SPUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private final static String JSON_CACHE = "JSON_CACHE";

    /**
     * 存入自定义的标识的数据 可以近似的看作网络下载数据的缓存
     * 单条方式存入
     *
     * @param tag     存入内容的标记，约定俗成的tag用当前的类名命名来区分不同的sp
     * @param content 存入的内
     */
    public static void putContent(String tag, String content) {
        putString(tag, content);
    }

    /**
     * 获取以tag命名的存储内
     *
     * @param tag 命名的tag
     * @return 返回以tag区分的内容，默认为空
     */
    public static String getContent(String tag) {
        return getString(tag);
    }

    /**
     * SP中写入String类型value
     *
     * @param key   键
     * @param value 值
     */
    public static void putString(String key, String value) {
        SharedPreferences sp = Utils.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * SP中读取String
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值{@code defaultValue}
     */
    public static String getString(String key) {
        SharedPreferences sp = Utils.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        String value;
        value = sp.getString(key, "");
        return value;
    }

    /**
     * SP中写入int类型value
     *
     * @param key   键
     * @param value 值
     */
    public static void putInt(String key, int value) {
        SharedPreferences sp = Utils.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * SP中读取int
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值-1
     */
    public static int getInt(String key) {
        SharedPreferences sp = Utils.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        int value;
        value = sp.getInt(key, -1);
        return value;
    }

    /**
     * SP中写入long类型value
     *
     * @param key   键
     * @param value 值
     */
    public static void putLong(String key, long value) {
        SharedPreferences sp = Utils.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * SP中读取long
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值-1
     */
    public static long getLong(String key) {
        SharedPreferences sp = Utils.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        long value;
        value = sp.getLong(key, -1L);
        return value;
    }

    /**
     * SP中写入float类型value
     *
     * @param key   键
     * @param value 值
     */
    public static void putFloat(String key, float value) {
        SharedPreferences sp = Utils.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    /**
     * SP中读取float
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值-1
     */
    public static float getFloat(String key) {
        SharedPreferences sp = Utils.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        float value;
        value = sp.getFloat(key, -1F);
        return value;
    }

    /**
     * SP中写入boolean类型value
     *
     * @param key   键
     * @param value 值
     */
    public static void putBoolean(String key, boolean value) {
        SharedPreferences sp = Utils.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * SP中读取boolean
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值{@code defaultValue}
     */
    public static boolean getBoolean(String key) {
        SharedPreferences sp = Utils.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        boolean value;
        value = sp.getBoolean(key, false);
        return value;
    }

    /**
     * SP中移除该key
     *
     * @param key 键
     */
    public static void remove(String key) {
        SharedPreferences sp = Utils.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
        sp.edit().remove(key).apply();
    }


    /**
     * 存放JSON缓存数据
     *
     * @param key     键名
     * @param content 内容
     * @return
     */
    public static void putJSONCache(String key, String content) {
        SharedPreferences sp = Utils.getContext().getSharedPreferences(JSON_CACHE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, content);
        editor.apply();

    }

    /**
     * 读取JSON缓存数据
     *
     * @param key 键名
     * @return
     */
    public static String readJSONCache(String key) {
        SharedPreferences sp = Utils.getContext().getSharedPreferences(JSON_CACHE, Context.MODE_PRIVATE);
        String jsoncache = sp.getString(key, null);
        return jsoncache;
    }


    /**
     * 清除指定的信息
     *
     * @param name 键名
     * @param key  若为null 则删除name下所有的键值
     */
    public static void clearPreference(String name, String key) {
        SharedPreferences sharedPreferences = Utils.getContext().getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (key != null) {
            editor.remove(key);
        } else {
            editor.clear();
        }
        editor.apply();
    }
}
