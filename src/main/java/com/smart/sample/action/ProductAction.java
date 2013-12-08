package com.smart.sample.action;

import com.smart.framework.DataContext;
import com.smart.framework.annotation.Bean;
import com.smart.framework.annotation.Inject;
import com.smart.framework.annotation.Request;
import com.smart.framework.base.BaseAction;
import com.smart.framework.bean.Multipart;
import com.smart.framework.bean.Page;
import com.smart.framework.bean.Pager;
import com.smart.framework.bean.Result;
import com.smart.framework.helper.UploadHelper;
import com.smart.framework.util.CastUtil;
import com.smart.sample.Constant;
import com.smart.sample.bean.ProductBean;
import com.smart.sample.entity.ProductType;
import com.smart.sample.service.ProductService;
import java.util.List;
import java.util.Map;

@Bean
public class ProductAction extends BaseAction {

    @Inject
    private ProductService productService;

    @Request("GET:/product")
    public Page index() {
        int pageNumber = 1;
        int pageSize = CastUtil.castInt(DataContext.Cookie.get("cookie_ps_product_pager"), 10);
        String productName = "";

        Pager<ProductBean> productBeanPager = productService.getProductBeanPager(pageNumber, pageSize, productName);
        return new Page("product.jsp")
            .data("productBeanPager", productBeanPager);
    }

    @Request("POST:/product/search")
    public Page search(Map<String, Object> fieldMap) {
        int pageNumber = CastUtil.castInt(fieldMap.get(PAGE_NUMBER));
        int pageSize = CastUtil.castInt(fieldMap.get(PAGE_SIZE));
        String productName = CastUtil.castString(fieldMap.get("productName"));

        Pager<ProductBean> productBeanPager = productService.getProductBeanPager(pageNumber, pageSize, productName);
        return new Page("product_list.jsp")
            .data("productBeanPager", productBeanPager);
    }

    @Request("GET:/product/view/{id}")
    public Page view(long id) {
        ProductBean productBean = productService.getProductBean(id);
        return new Page("product_view.jsp")
            .data("productBean", productBean);
    }

    @Request("GET:/product/edit/{id}")
    public Page edit(long id) {
        List<ProductType> productTypeList = productService.getProductTypeList();
        ProductBean productBean = productService.getProductBean(id);
        return new Page("product_edit.jsp")
            .data("productTypeList", productTypeList)
            .data("productBean", productBean);
    }

    @Request("GET:/product/create")
    public Page create() {
        List<ProductType> productTypeList = productService.getProductTypeList();
        return new Page("product_create.jsp")
            .data("productTypeList", productTypeList);
    }

    @Request("POST:/product/create")
    public Result create(Map<String, Object> fieldMap, Multipart multipart) {
        boolean success = productService.createProduct(fieldMap);
        if (success) {
            String basePath = DataContext.getServletContext().getRealPath("") + Constant.UPLOAD_PATH;
            UploadHelper.upload(basePath, multipart);
        }
        return new Result(success);
    }

    @Request("PUT:/product/update/{id}")
    public Result update(long id, Map<String, Object> fieldMap) {
        boolean success = productService.updateProduct(id, fieldMap);
        return new Result(success);
    }

    @Request("POST:/product/upload/{id}")
    public Result upload(long id, Map<String, Object> fieldMap, Multipart multipart) {
        boolean success = productService.updateProduct(id, fieldMap);
        if (success) {
            String basePath = DataContext.getServletContext().getRealPath("") + Constant.UPLOAD_PATH;
            UploadHelper.upload(basePath, multipart);
        }
        return new Result(success)
            .data(multipart.getFileName());
    }

    @Request("DELETE:/product/delete/{id}")
    public Result delete(long id) {
        boolean success = productService.deleteProduct(id);
        return new Result(success);
    }
}
