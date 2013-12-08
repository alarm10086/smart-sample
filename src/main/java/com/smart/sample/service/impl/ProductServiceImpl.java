package com.smart.sample.service.impl;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Bean;
import com.smart.framework.base.BaseService;
import com.smart.framework.bean.Pager;
import com.smart.sample.entity.Product;
import com.smart.sample.service.ProductService;
import java.util.List;
import java.util.Map;

@Bean
public class ProductServiceImpl extends BaseService implements ProductService {

    @Override
    public boolean createProduct(Map<String, Object> fieldMap) {
        return DataSet.insert(Product.class, fieldMap);
    }

    @Override
    public boolean deleteProduct(long id) {
        return DataSet.delete(Product.class, "id = ?", id);
    }

    @Override
    public boolean updateProduct(long id, Map<String, Object> fieldMap) {
        return DataSet.update(Product.class, fieldMap, "id = ?", id);
    }

    @Override
    public Product getProduct(long id) {
        return DataSet.select(Product.class, "id = ?", id);
    }

    @Override
    public List<Product> getProductList() {
        return DataSet.selectList(Product.class, "", "id desc");
    }

    @Override
    public List<Product> getProductList(String productName) {
        String condition = "product_name like ?";
        String sort = "id desc";
        Object[] params = {'%' + productName + '%'};
        return DataSet.selectList(Product.class, condition, sort, params);
    }

    @Override
    public Pager<Product> getProductPager(int pageNumber, int pageSize, String productName) {
        String condition = "product_name like ?";
        String sort = "id desc";
        Object[] params = {'%' + productName + '%'};
        int count = DataSet.selectCount(Product.class, condition, params);
        List<Product> productList = DataSet.selectListForPager(pageNumber, pageSize, Product.class, condition, sort, params);
        return new Pager<Product>(pageNumber, pageSize, count, productList);
    }
}
