package com.smart.sample.service.impl;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Bean;
import com.smart.framework.base.BaseService;
import com.smart.framework.bean.Pager;
import com.smart.sample.bean.ProductBean;
import com.smart.sample.entity.Product;
import com.smart.sample.entity.ProductType;
import com.smart.sample.service.ProductService;
import java.util.ArrayList;
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
    public ProductBean getProductBean(long productId) {
        ProductBean productBean = null;
        Product product = DataSet.select(Product.class, "id = ?", productId);
        if (product != null) {
            ProductType productType = DataSet.select(ProductType.class, "id = ?", product.getProductTypeId());
            if (productType != null) {
                productBean = new ProductBean(product, productType);
            }
        }
        return productBean;
    }

    @Override
    public Pager<ProductBean> getProductBeanPager(int pageNumber, int pageSize, String productName) {
        String condition = "product_name like ?";
        String sort = "id desc";
        Object[] params = {'%' + productName + '%'};

        int count = DataSet.selectCount(Product.class, condition, params);
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
