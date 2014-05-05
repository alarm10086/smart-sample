package org.smart4j.sample.test;

import java.util.HashMap;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smart4j.framework.dao.DatabaseHelper;
import org.smart4j.framework.dao.bean.Pager;
import org.smart4j.framework.ioc.BeanHelper;
import org.smart4j.framework.test.OrderedRunner;
import org.smart4j.framework.test.annotation.TestOrder;
import org.smart4j.sample.bean.ProductBean;
import org.smart4j.sample.service.ProductService;
import org.smart4j.sample.service.impl.ProductServiceImpl;

@RunWith(OrderedRunner.class)
public class ProductServiceTest {

    private ProductService productService = BeanHelper.getBean(ProductServiceImpl.class);

    @BeforeClass
    @AfterClass
    public static void init() {
        DatabaseHelper.initSQL("sql/product.sql");
    }

    @Test
    @TestOrder(1)
    public void getProductBeanPagerTest() {
        int pageNumber = 1;
        int pageSize = 10;
        String name = "";

        Pager<ProductBean> productBeanPager = productService.getProductBeanPager(pageNumber, pageSize, name);
        Assert.assertNotNull(productBeanPager);
        Assert.assertEquals(productBeanPager.getRecordList().size(), 10);
        Assert.assertEquals(productBeanPager.getTotalRecord(), 12);
    }

    @Test
    @TestOrder(2)
    public void getProductBeanTest() {
        long productId = 1;

        ProductBean productBean = productService.getProductBean(productId);
        Assert.assertNotNull(productBean);
        Assert.assertNotNull(productBean.getProduct());
        Assert.assertNotNull(productBean.getProductType());
    }

    @Test
    @TestOrder(3)
    public void createProductTest() {
        Map<String, Object> productFieldMap = new HashMap<String, Object>();
        productFieldMap.put("productTypeId", 1);
        productFieldMap.put("name", "1");
        productFieldMap.put("code", "1");
        productFieldMap.put("price", 1);
        productFieldMap.put("description", "1");

        boolean result = productService.createProduct(productFieldMap, null);
        Assert.assertTrue(result);
    }

    @Test
    @TestOrder(4)
    public void updateProductTest() {
        long productId = 1;
        Map<String, Object> productFieldMap = new HashMap<String, Object>();
        productFieldMap.put("name", "1");
        productFieldMap.put("code", "1");

        boolean result = productService.updateProduct(productId, productFieldMap, null);
        Assert.assertTrue(result);
    }

    @Test
    @TestOrder(5)
    public void deleteProductTest() {
        long productId = 1;

        boolean result = productService.deleteProduct(productId);
        Assert.assertTrue(result);
    }
}
