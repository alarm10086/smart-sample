package com.smart.sample.test;

import com.smart.plugin.ws.RESTHelper;
import com.smart.sample.entity.Product;
import com.smart.sample.ws.rest.ProductService2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class ProductServiceRESTTest2 {

    private String wadl = "http://localhost:8080/smart-sample/ws/ProductService2";

    private ProductService2 productService = RESTHelper.createClient(wadl, ProductService2.class);

    @Test
    public void getProductListTest() {
        List<Product> productList = productService.getProductList();
        System.out.println(productList);
    }

    @Test
    public void getProductTest() {
        Product product = productService.getProduct(1);
        System.out.println(product);
    }

    @Test
    public void createProductTest() {
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("product_type_id", 1);
        fieldMap.put("product_name", "1");
        fieldMap.put("product_code", "1");
        fieldMap.put("price", 1);
        fieldMap.put("description", "1");
        productService.createProduct(fieldMap);
    }
}
