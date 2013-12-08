package com.smart.sample.service;

import com.smart.framework.bean.Pager;
import com.smart.sample.entity.Product;
import java.util.List;
import java.util.Map;

public interface ProductService {

    boolean createProduct(Map<String, Object> fieldMap);

    boolean deleteProduct(long id);

    boolean updateProduct(long id, Map<String, Object> fieldMap);

    Product getProduct(long id);

    List<Product> getProductList();

    List<Product> getProductList(String productName);

    Pager<Product> getProductPager(int pageNumber, int pageSize, String productName);
}
