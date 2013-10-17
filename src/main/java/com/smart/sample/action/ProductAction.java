package com.smart.sample.action;

import com.smart.framework.annotation.Bean;
import com.smart.framework.annotation.Inject;
import com.smart.framework.annotation.Request;
import com.smart.framework.base.BaseAction;
import com.smart.framework.bean.Pager;
import com.smart.framework.bean.Result;
import com.smart.framework.util.CastUtil;
import com.smart.framework.util.WebUtil;
import com.smart.sample.bean.ProductBean;
import com.smart.sample.service.ProductService;
import java.util.Map;

@Bean
public class ProductAction extends BaseAction {

    @Inject
    private ProductService productService;

    @Request("get:/product")
    public Result index() {
        Pager<ProductBean> productBeanPager = productService.searchProductPager(1, 10, null);
        return new Result(true).data(productBeanPager);
    }

    @Request("post:/product/search")
    public Result search(Map<String, Object> formFieldMap) {
        int pageNumber = CastUtil.castInt(formFieldMap.get(PAGE_NUMBER));
        int pageSize = CastUtil.castInt(formFieldMap.get(PAGE_SIZE));
        String queryString = CastUtil.castString(formFieldMap.get(QUERY_STRING));

        Map<String, String> queryMap = WebUtil.createQueryMap(queryString);

        Pager<ProductBean> productBeanPager = productService.searchProductPager(pageNumber, pageSize, queryMap);
        return new Result(true).data(productBeanPager);
    }

    @Request("get:/product/show/{id}")
    public Result show(long id) {
        if (id == 0) {
            return new Result(false).error(ERROR_PARAM);
        }
        ProductBean productBean = productService.getProductBean(id);
        if (productBean != null) {
            return new Result(true).data(productBean);
        } else {
            return new Result(false).error(ERROR_DATA);
        }
    }

    @Request("post:/product/create")
    public Result create(Map<String, Object> formFieldMap) {
        boolean success = productService.createProduct(formFieldMap);
        return new Result(success);
    }

    @Request("put:/product/update/{id}")
    public Result update(long id, Map<String, Object> formFieldMap) {
        if (id == 0) {
            return new Result(false).error(ERROR_PARAM);
        }
        boolean success = productService.updateProduct(id, formFieldMap);
        return new Result(success);
    }

    @Request("delete:/product/delete/{id}")
    public Result delete(long id) {
        if (id == 0) {
            return new Result(false).error(ERROR_PARAM);
        }
        boolean success = productService.deleteProduct(id);
        return new Result(success);
    }
}
