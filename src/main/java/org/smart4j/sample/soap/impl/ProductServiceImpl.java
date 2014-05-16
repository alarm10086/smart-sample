package org.smart4j.sample.soap.impl;

import java.util.List;
import java.util.Map;
import org.smart4j.framework.orm.Conditions;
import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.orm.Sorts;
import org.smart4j.framework.tx.annotation.Service;
import org.smart4j.framework.tx.annotation.Transaction;
import org.smart4j.sample.entity.Product;
import org.smart4j.sample.soap.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> getProductList() {
        return DataSet.selectList(Product.class, null, new Sorts().sort("id", "asc"));
    }

    @Override
    public Product getProduct(long productId) {
        return DataSet.select(Product.class, new Conditions().condition("id", "=", "?"), productId);
    }

    @Override
    @Transaction
    public boolean createProduct(Map<String, Object> productFieldMap) {
        return DataSet.insert(Product.class, productFieldMap);
    }

    @Override
    @Transaction
    public boolean updateProduct(long productId, Map<String, Object> productFieldMap) {
        return DataSet.update(Product.class, productFieldMap, new Conditions().condition("id", "=", "?"), productId);
    }

    @Override
    @Transaction
    public boolean deleteProduct(long productId) {
        return DataSet.delete(Product.class, new Conditions().condition("id", "=", "?"), productId);
    }
}
