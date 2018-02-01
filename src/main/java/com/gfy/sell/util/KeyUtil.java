package com.gfy.sell.util;

import java.util.Random;

/**
 * key工具类
 *
 * @author gfy
 */
public class KeyUtil {

    private static Random random = new Random();

    public static synchronized String getUniqueKey() {
        Integer number = random.nextInt(9000000) + 100000;
        return String.valueOf(System.currentTimeMillis() + number);
    }

}
