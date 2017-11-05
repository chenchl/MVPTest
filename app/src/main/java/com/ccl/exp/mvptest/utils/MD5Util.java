package com.ccl.exp.mvptest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * Created by ccl on 2016/10/21.
 * MD5
 */
public class MD5Util {
    public static String getMD5(byte[] source, boolean bIsUpper) {
        String s = null;
        String sTmp = null;
        try {
            MessageDigest md = MessageDigest
                    .getInstance("MD5");
            md.update(source);
            byte tmp[] = md.digest();
            sTmp = getHexString(tmp);
            if (bIsUpper) {
                s = exChange(sTmp);
            } else {
                s = sTmp;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String fileGetMD5(File file) {
        FileInputStream fis = null;
        String s = null;
        String sTmp = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[2048];
            int length = -1;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            byte[] tmp = md.digest();
            sTmp = getHexString(tmp);
            s = exChange(sTmp);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static String getHexString(byte[] bytes) {
        String result = "";
        for (int i = 0; i < bytes.length; i++) {
            result += Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                    .substring(1);
        }
        return result;
    }

    private static String exChange(String str) {
        StringBuffer sb = new StringBuffer();
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (Character.isUpperCase(c)) {
                    sb.append(Character.toLowerCase(c));
                } else if (Character.isLowerCase(c)) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    private static String exChange2(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(
                    str.substring(i, i + 1).toLowerCase())) {
                str.substring(i, i + 1).toUpperCase();
            } else {
                str.substring(i, i + 1).toLowerCase();
            }
        }
        return str;
    }
}
