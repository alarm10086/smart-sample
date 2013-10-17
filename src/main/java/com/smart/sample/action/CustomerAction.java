package com.smart.sample.action;

import com.smart.framework.annotation.Bean;
import com.smart.framework.annotation.Request;
import com.smart.framework.base.BaseAction;
import com.smart.framework.bean.Page;
import java.util.HashMap;
import java.util.Map;

@Bean
public class CustomerAction extends BaseAction {

    @Request("get:/customer")
    public Page index() {
        String aaa = "aaa";
        String bbb = "bbb";
        String ccc = "ccc";

        return new Page("customer.html")
            .data("aaa", aaa)
            .data("bbb", bbb)
            .data("ccc", ccc);
    }

    @Request("get:/customer")
    public Page index2() {
        String aaa = "aaa";
        String bbb = "bbb";
        String ccc = "ccc";

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("aaa", aaa);
        data.put("bbb", bbb);
        data.put("ccc", ccc);

        return new Page("customer.html", data);
    }

    @Request("get:/customer")
    public Page index3() {
        String aaa = "aaa";
        String bbb = "bbb";
        String ccc = "ccc";

        return new Page("customer.html",
            "aaa", aaa,
            "bbb", bbb,
            "ccc", ccc
        );
    }
}
