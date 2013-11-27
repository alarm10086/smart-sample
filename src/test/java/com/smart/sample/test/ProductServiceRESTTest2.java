package com.smart.sample.test;

import com.smart.plugin.ws.RESTHelper;
import com.smart.sample.entity.Product;
import com.smart.sample.ws.rest.ProductService2;
import org.junit.Test;

public class ProductServiceRESTTest2 {

    @Test
    public void getProductTest() {
        String wadl = "http://localhost:8080/smart-sample/ws/ProductService2";
        ProductService2 productService = RESTHelper.createClient(wadl, ProductService2.class);
        Product product = productService.getProduct(1);
        System.out.println(product);
    }
}
