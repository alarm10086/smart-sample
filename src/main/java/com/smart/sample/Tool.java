package com.smart.sample;

import com.smart.framework.DataContext;
import com.smart.framework.util.CastUtil;

public class Tool {

    public static int getPageSize() {
        return CastUtil.castInt(DataContext.Cookie.get("cookie_ps_product_pager"), 10);
    }

    public static String getBasePath() {
        return DataContext.getServletContext().getRealPath("") + Constant.UPLOAD_PATH;
    }
}
