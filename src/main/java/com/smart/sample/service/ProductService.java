package com.smart.sample.service;

import com.smart.framework.bean.Pager;
import com.smart.sample.bean.ProductBean;
import com.smart.sample.entity.Product;
import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Product> getProductList();

    Product getProduct(long productId);

    boolean createProduct(Map<String, Object> productFieldMap);

    boolean updateProduct(long productId, Map<String, Object> productFieldMap);

    boolean deleteProduct(long productId);

//    Pager<Product> searchProductPager(int pageNumber, int pageSize, Map<String, String> formFieldMap);
    Pager<ProductBean> searchProductPager(int pageNumber, int pageSize, Map<String, String> formFieldMap);
}
