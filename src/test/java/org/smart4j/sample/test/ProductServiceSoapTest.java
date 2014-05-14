package org.smart4j.sample.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.smart4j.plugin.soap.SoapHelper;
import org.smart4j.sample.entity.Product;
import org.smart4j.sample.soap.ProductService;

public class ProductServiceSoapTest {

    private String wsdl = "http://localhost:8080/smart-sample/soap/product";
    private ProductService productService = SoapHelper.createClient(wsdl, ProductService.class);

    @Test
    public void getProductListTest() {
        List<Product> productList = productService.getProductList();
        Assert.assertNotNull(productList);
        Assert.assertEquals(productList.size(), 12);
    }

    @Test
    public void getProductTest() {
        long productId = 1;

        Product product = productService.getProduct(productId);
        Assert.assertNotNull(product);
    }

    @Test
    public void createProductTest() {
        Map<String, Object> productFieldMap = new HashMap<String, Object>();
        productFieldMap.put("productTypeId", 1);
        productFieldMap.put("name", "1");
        productFieldMap.put("code", "1");
        productFieldMap.put("price", 1);
        productFieldMap.put("description", "1");

        boolean result = productService.createProduct(productFieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void updateProductTest() {
        long productId = 13;
        Map<String, Object> productFieldMap = new HashMap<String, Object>();
        productFieldMap.put("name", "13");
        productFieldMap.put("code", "13");

        boolean result = productService.updateProduct(productId, productFieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteProductTest() {
        long productId = 13;

        boolean result = productService.deleteProduct(productId);
        Assert.assertTrue(result);
    }
}
