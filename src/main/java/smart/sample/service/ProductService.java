package smart.sample.service;

import java.util.List;
import java.util.Map;
import smart.framework.dao.bean.Pager;
import smart.framework.mvc.bean.Multipart;
import smart.sample.bean.ProductBean;
import smart.sample.entity.Product;
import smart.sample.entity.ProductType;

public interface ProductService {

    boolean createProduct(Map<String, Object> fieldMap, Multipart multipart);

    boolean deleteProduct(long id);

    boolean updateProduct(long id, Map<String, Object> fieldMap, Multipart multipart);

    Product getProduct(long id);

    ProductBean getProductBean(long id);

    Pager<ProductBean> getProductBeanPager(int pageNumber, int pageSize, String name);

    List<ProductType> getProductTypeList();
}
