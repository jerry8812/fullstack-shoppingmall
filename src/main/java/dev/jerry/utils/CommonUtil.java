package dev.jerry.utils;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class CommonUtil {

    /**
     * Create random primary key uuid for all tables
     * @return String uuid
     */
    public static String createUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }

    /**
     * encrypt password with md5
     * @param password
     * @return password after encrypted
     */
    public static String toMD5(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
    }
}
