package org.smart4j.sample.soap;

import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.smart4j.plugin.soap.Soap;
import org.smart4j.sample.entity.Product;
import org.smart4j.sample.soap.adapter.StringObjectMapAdapter;

@Soap("/product")
public interface ProductService {

    List<Product> getProductList();

    Product getProduct(long productId);

    boolean createProduct(@XmlJavaTypeAdapter(StringObjectMapAdapter.class) Map<String, Object> productFieldMap);

    boolean updateProduct(long productId, @XmlJavaTypeAdapter(StringObjectMapAdapter.class) Map<String, Object> productFieldMap);

    boolean deleteProduct(long productId);
}
