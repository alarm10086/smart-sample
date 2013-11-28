package com.smart.sample.test;

import com.smart.plugin.ws.RESTClient;
import com.smart.sample.entity.Product;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class ProductServiceRESTTest1 {

    private String wadl = "http://localhost:8080/smart-sample/ws/ProductService";

    @Test
    public void getProductListTest() {
        List productList = RESTClient.get(wadl, "/products", null, List.class);
        System.out.println(productList.size());
    }

    @Test
    public void getProductTest() {
        Product product = RESTClient.get(wadl, "/product/1", null, Product.class);
        System.out.println(product);
    }

    @Test
    public void createProductTest() {
        Map<String, Object> productFieldMap = new HashMap<String, Object>();
        productFieldMap.put("product_type_id", 1);
        productFieldMap.put("product_name", "1");
        productFieldMap.put("product_code", "1");
        productFieldMap.put("price", 1);
        productFieldMap.put("description", "1");
        RESTClient.post(wadl, "/product", productFieldMap, HashMap.class);
    }
}
