package org.smart4j.sample;

import org.smart4j.framework.core.ConfigHelper;

public interface Constant {

    String CAPTCHA = "session.captcha";

    String PAGE_NUMBER = "pageNumber";
    String PAGE_SIZE = "pageSize";

    String UPLOAD_PATH = ConfigHelper.getString("sample.upload_path");
}
