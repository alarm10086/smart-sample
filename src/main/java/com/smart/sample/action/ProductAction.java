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
import com.smart.sample.entity.Product;
import com.smart.sample.service.ProductService;
import java.util.Map;

@Bean
public class ProductAction extends BaseAction {

    @Inject
    private ProductService productService;

    @Request("get:/products")
    public Result getProducts() {
        Pager<ProductBean> productBeanPager = productService.searchProductPager(1, 10, null);
        return new Result(true).data(productBeanPager);
    }

    @Request("get:/product/{id}")
    public Result getProductById(long productId) {
        if (productId == 0) {
            return new Result(false).error(ERROR_PARAM);
        }
        Product product = productService.getProduct(productId);
        if (product != null) {
            return new Result(true).data(product);
        } else {
            return new Result(false).error(ERROR_DATA);
        }
    }

    @Request("post:/product")
    public Result createProduct(Map<String, Object> formFieldMap) {
        boolean success = productService.createProduct(formFieldMap);
        return new Result(true);
    }

    @Request("put:/product/{id}")
    public Result updateProduct(long productId, Map<String, Object> formFieldMap) {
        if (productId == 0) {
            return new Result(false).error(ERROR_PARAM);
        }
        boolean success = productService.updateProduct(productId, formFieldMap);
        return new Result(success);
    }

    @Request("delete:/product/{id}")
    public Result deleteProductById(long productId) {
        if (productId == 0) {
            return new Result(false).error(ERROR_PARAM);
        }
        boolean success = productService.deleteProduct(productId);
        return new Result(success);
    }

    @Request("post:/products")
    public Result searchProducts(Map<String, String> formFieldMap) {
        int pageNumber = CastUtil.castInt(formFieldMap.get("pageNumber"));
        int pageSize = CastUtil.castInt(formFieldMap.get("pageSize"));
        String queryString = formFieldMap.get("queryString");

        Map<String, String> queryMap = WebUtil.createQueryMap(queryString);

        Pager<ProductBean> productBeanPager = productService.searchProductPager(pageNumber, pageSize, queryMap);
        return new Result(true).data(productBeanPager);
    }
}
