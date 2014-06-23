package org.smart4j.sample.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smart4j.framework.test.OrderedRunner;
import org.smart4j.framework.test.annotation.TestOrder;
import org.smart4j.sample.entity.Product;
import org.smart4j.sample.rest.ProductService;

@RunWith(OrderedRunner.class)
public class ProductServiceRestTest {

    private ProductService productService;

    @Before
    public void before() {
        List<Object> providerList = new ArrayList<Object>();
        providerList.add(new JacksonJsonProvider());

        productService = JAXRSClientFactory.create(
            "http://localhost:8080/smart-sample/rest/ProductService",
            ProductService.class,
            providerList
        );
    }

    @Test
    @TestOrder(1)
    public void getProductListTest() {
        List<Product> productList = productService.getProductList();
        Assert.assertNotNull(productList);
    }

    @Test
    @TestOrder(2)
    public void getProductTest() {
        long productId = 1;

        Product product = productService.getProduct(productId);
        Assert.assertNotNull(product);
    }

    @Test
    @TestOrder(3)
    public void createProductTest() {
        Map<String, Object> productFieldMap = new HashMap<String, Object>();
        productFieldMap.put("id", Long.MAX_VALUE);
        productFieldMap.put("productTypeId", 1);
        productFieldMap.put("name", "test");
        productFieldMap.put("code", "test");
        productFieldMap.put("price", 1000);
        productFieldMap.put("description", "test");

        boolean result = productService.createProduct(productFieldMap);
        Assert.assertTrue(result);
    }

    @Test
    @TestOrder(4)
    public void updateProductTest() {
        long productId = Long.MAX_VALUE;
        Map<String, Object> productFieldMap = new HashMap<String, Object>();
        productFieldMap.put("name", "test2");
        productFieldMap.put("code", "test2");

        boolean result = productService.updateProduct(productId, productFieldMap);
        Assert.assertTrue(result);
    }

    @Test
    @TestOrder(5)
    public void deleteProductTest() {
        long productId = Long.MAX_VALUE;

        boolean result = productService.deleteProduct(productId);
        Assert.assertTrue(result);
    }
}
