package com.ccl.exp.mvptest.net.params;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ccl on 2016/3/23.
 * Post请求参数
 */

public class PostParams extends BaseParams {

    public boolean hasFile = false;
    private FormFile formFile = new FormFile();

    /**
     * 获取post信息中是否含有file
     *
     * @return
     */
    public boolean isHasFile() {
        return hasFile;
    }

    /**
     * 通知okhttp有file上传
     *
     * @param hasFile
     */
    public void setHasFile(boolean hasFile) {
        this.hasFile = hasFile;
    }

    public void addParams(String key, String value) {
        this.put(key, value);
    }

    public void addFile(String key, File f) {
        hasFile = true;
        if (f.exists()) {
            formFile.addFormFile(key, f);
        }
    }

    public FormFile getFormFile() {
        return formFile;
    }

    public void setFormFile(FormFile formFile) {
        this.formFile = formFile;
    }


    public String getString() {
        int i = 0;
        String s = "";
        Iterator iter = entrySet().iterator();
        while (iter.hasNext()) {
            if (i != 0) {
                s = s + "&";
            }
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            String val = (String) entry.getValue();
            s = s + key + "=" + val;
            i++;
        }
        return s;
    }
}
