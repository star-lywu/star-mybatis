package com.starylwu.mybatis.helper;

/**
 * @Author: WuYuLong
 * @Date: Create in 16:20 2018/8/27
 * @DESC:
 */
public class StringHelper {

    /**
     * 将首字母大写
     * @param value
     * @return
     */
    private String toUpFirst(String value){
        char[] chars = value.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }
}
