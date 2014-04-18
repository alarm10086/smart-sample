package smart.sample.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import smart.framework.DataSet;
import smart.framework.annotation.Inject;
import smart.framework.annotation.Service;
import smart.framework.annotation.Transaction;
import smart.framework.bean.Multipart;
import smart.framework.bean.Pager;
import smart.framework.helper.UploadHelper;
import smart.sample.Tool;
import smart.sample.bean.ProductBean;
import smart.sample.entity.Product;
import smart.sample.entity.ProductType;
import smart.sample.service.LogService;
import smart.sample.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Inject
    private LogService logService;

    @Override
    @Transaction
    public boolean createProduct(Map<String, Object> fieldMap, Multipart multipart) {
        if (multipart != null) {
            fieldMap.put("picture", multipart.getFileName());
        }
        boolean result = DataSet.insert(Product.class, fieldMap);
        if (result && multipart != null) {
            UploadHelper.uploadFile(Tool.getBasePath(), multipart);
        }
        return result;
    }

    @Override
    @Transaction
    public boolean deleteProduct(long id) {
        return DataSet.delete(Product.class, "id = ?", id);
    }

    @Override
    @Transaction
    public boolean updateProduct(long id, Map<String, Object> fieldMap, Multipart multipart) {
        if (multipart != null) {
            fieldMap.put("picture", multipart.getFileName());
        }
        boolean result = DataSet.update(Product.class, fieldMap, "id = ?", id);
        if (result && multipart != null) {
            UploadHelper.uploadFile(Tool.getBasePath(), multipart);
        }

        logService.log("update product by id is " + id);

        return result;
    }

    @Override
    public Product getProduct(long id) {
        return DataSet.select(Product.class, "id = ?", id);
    }

    @Override
    public ProductBean getProductBean(long id) {
        ProductBean productBean = null;
        Product product = getProduct(id);
        if (product != null) {
            ProductType productType = DataSet.select(ProductType.class, "id = ?", product.getProductTypeId());
            if (productType != null) {
                productBean = new ProductBean(product, productType);
            }
        }
        return productBean;
    }

    @Override
    public Pager<ProductBean> getProductBeanPager(int pageNumber, int pageSize, String name) {
        String condition = "name like ?";
        String sort = "id desc";
        Object[] params = {"%" + name + "%"};

        long count = DataSet.selectCount(Product.class, condition, params);
        List<ProductBean> productBeanList = new ArrayList<ProductBean>();
        List<Product> productList = DataSet.selectListForPager(pageNumber, pageSize, Product.class, condition, sort, params);
        Map<Long, ProductType> productTypeMap = DataSet.selectMap(ProductType.class, "");
        for (Product product : productList) {
            ProductType productType = productTypeMap.get(product.getProductTypeId());
            if (productType != null) {
                productBeanList.add(new ProductBean(product, productType));
            }
        }
        return new Pager<ProductBean>(pageNumber, pageSize, count, productBeanList);
    }

    @Override
    public List<ProductType> getProductTypeList() {
        return DataSet.selectList(ProductType.class, "", "");
    }
}
