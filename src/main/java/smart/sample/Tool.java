package smart.sample;

import smart.framework.mvc.DataContext;
import smart.framework.util.CastUtil;

public class Tool {

    public static int getPageSize(String key) {
        return CastUtil.castInt(DataContext.Cookie.get("cookie.ps_" + key), 10);
    }

    public static String getBasePath() {
        return DataContext.getServletContext().getRealPath("") + Constant.UPLOAD_PATH;
    }
}
