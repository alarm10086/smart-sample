package org.smart4j.sample.bean;

import org.smart4j.framework.core.bean.BaseBean;
import org.smart4j.sample.entity.Product;
import org.smart4j.sample.entity.ProductType;

public class ProductBean extends BaseBean {

    private Product product;
    private ProductType productType;

    public ProductBean(Product product, ProductType productType) {
        this.product = product;
        this.productType = productType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
