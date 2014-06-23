package org.smart4j.sample.hessian;

import java.util.List;
import java.util.Map;
import org.smart4j.plugin.hessian.Hessian;
import org.smart4j.sample.entity.Product;

@Hessian
public interface ProductService {

    List<Product> getProductList();

    Product getProduct(long productId);

    boolean createProduct(Map<String, Object> productFieldMap);

    boolean updateProduct(long productId, Map<String, Object> productFieldMap);

    boolean deleteProduct(long productId);
}