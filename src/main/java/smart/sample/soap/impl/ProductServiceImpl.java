package smart.sample.soap.impl;

import java.util.List;
import java.util.Map;
import smart.framework.dao.DataSet;
import smart.framework.tx.annotation.Service;
import smart.framework.tx.annotation.Transaction;
import smart.sample.entity.Product;
import smart.sample.soap.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

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
