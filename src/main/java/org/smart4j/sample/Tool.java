package org.smart4j.sample;

import org.smart4j.framework.mvc.DataContext;
import org.smart4j.framework.util.CastUtil;

public class Tool {

    public static int getPageSize(String key) {
        return CastUtil.castInt(DataContext.Cookie.get("cookie.ps_" + key), 10);
    }

    public static String getBasePath() {
        return DataContext.getServletContext().getRealPath("") + Constant.UPLOAD_PATH;
    }
}
