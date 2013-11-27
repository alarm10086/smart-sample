package com.smart.sample.test;

import com.smart.plugin.ws.RESTClient;
import com.smart.sample.entity.Product;
import org.junit.Test;

public class ProductServiceRESTTest1 {

    @Test
    public void getProductTest() {
        String wadl = "http://localhost:8080/smart-sample/ws/ProductService";
        Product product = RESTClient.get(wadl, "/product/1", null, Product.class);
        System.out.println(product);
    }
}
