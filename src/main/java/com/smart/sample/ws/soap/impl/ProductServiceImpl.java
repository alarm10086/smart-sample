package com.smart.sample.ws.soap.impl;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Bean;
import com.smart.framework.annotation.Transaction;
import com.smart.framework.base.BaseService;
import com.smart.sample.entity.Product;
import com.smart.sample.ws.soap.ProductService;
import java.util.List;
import java.util.Map;

@Bean
public class ProductServiceImpl extends BaseService implements ProductService {

    @Override
    public List<Product> getProductList() {
        return DataSet.selectList(Product.class, "", "id asc");
    }

    @Override
    public Product getProduct(long productId) {
        return DataSet.select(Product.class, "id = ?", productId);
    }

    @Override
    @Transaction
    public boolean createProduct(Map<String, Object> productFieldMap) {
        return DataSet.insert(Product.class, productFieldMap);
    }

    @Override
    @Transaction
    public boolean updateProduct(long productId, Map<String, Object> productFieldMap) {
        return DataSet.update(Product.class, productFieldMap, "id = ?", productId);
    }

    @Override
    @Transaction
    public boolean deleteProduct(long productId) {
        return DataSet.delete(Product.class, "id = ?", productId);
    }
}
