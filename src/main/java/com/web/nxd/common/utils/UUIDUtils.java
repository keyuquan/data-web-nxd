package com.web.nxd.common.utils;

import java.util.UUID;

/**
 * @author lichunguang
 */
public class UUIDUtils {
    public static String randomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
