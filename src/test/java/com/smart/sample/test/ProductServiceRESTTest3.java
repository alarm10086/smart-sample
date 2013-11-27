package com.smart.sample.test;

import com.smart.framework.util.JSONUtil;
import com.smart.framework.util.WebUtil;
import com.smart.sample.entity.Product;
import org.junit.Test;

public class ProductServiceRESTTest3 {

    @Test
    public void getProductTest() {
        String url = "http://localhost:8080/smart-sample/ws/ProductService/product/1";
        String json = WebUtil.getURLContent(url);
        Product product = JSONUtil.fromJSON(json, Product.class);
        System.out.println(product);
    }
}
