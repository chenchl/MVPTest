package com.ccl.exp.mvptest.net.params;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 上传文件
 */
public class FormFile {

	public Map<String, File> inputStreamValueList = new HashMap<String, File>();

	public void addFormFile(String inputStreamKey, File inputStreamValue) {
		this.inputStreamValueList.put(inputStreamKey, inputStreamValue);
	}


}
