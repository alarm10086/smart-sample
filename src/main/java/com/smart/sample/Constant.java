package com.smart.sample;

import com.smart.framework.helper.ConfigHelper;

public interface Constant {

    String REDIRECT_URL = "session.redirect_url";

    String UPLOAD_PATH = ConfigHelper.getStringProperty("sample.upload_path");
}
