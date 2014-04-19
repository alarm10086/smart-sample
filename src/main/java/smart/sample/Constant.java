package smart.sample;

import smart.framework.core.ConfigHelper;

public interface Constant {

    String CAPTCHA = "session.captcha";

    String PAGE_NUMBER = "pageNumber";
    String PAGE_SIZE = "pageSize";

    String UPLOAD_PATH = ConfigHelper.getConfigString("sample.upload_path");
}
