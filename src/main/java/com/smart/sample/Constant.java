package com.smart.sample;

import com.smart.framework.helper.ConfigHelper;

public interface Constant {

    String CAPTCHA = "session.captcha";
    String USER_ID = "session.user_id";
    String REDIRECT_URL = "session.redirect_url";

    String PAGE_NUMBER = "pageNumber";
    String PAGE_SIZE = "pageSize";

    String UPLOAD_PATH = ConfigHelper.getConfigString("sample.upload_path");
}
