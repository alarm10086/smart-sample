package com.smart.sample;

import com.smart.framework.helper.ConfigHelper;

public interface Constant {

    String UPLOAD_PATH = ConfigHelper.getStringProperty("sample.upload_path");
}
