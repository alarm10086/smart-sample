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
import com.smart.sample.entity.Product;
import com.smart.sample.service.ProductService;
import java.util.Map;

@Bean
public class ProductAction extends BaseAction {

    @Inject
    private ProductService productService;

    @Request("get:/product")
    public Page index() {
        int pageNumber = 1;
        int pageSize = CastUtil.castInt(DataContext.Cookie.get("cookie_ps_product_pager"), 10);
        String productName = "";
        Pager<Product> productPager = productService.getProductPager(pageNumber, pageSize, productName);
        return new Page("product.jsp").data("productPager", productPager);
    }

    @Request("post:/product/search")
    public Page search(Map<String, Object> fieldMap) {
        int pageNumber = CastUtil.castInt(fieldMap.get(PAGE_NUMBER));
        int pageSize = CastUtil.castInt(fieldMap.get(PAGE_SIZE));
        String productName = CastUtil.castString(fieldMap.get("productName"));
        Pager<Product> productPager = productService.getProductPager(pageNumber, pageSize, productName);
        return new Page("product_list.jsp").data("productPager", productPager);
    }

    @Request("get:/product/view/{id}")
    public Page view(long id) {
        Product product = productService.getProduct(id);
        return new Page("product_view.jsp").data("product", product);
    }

    @Request("get:/product/edit/{id}")
    public Page edit(long id) {
        Product product = productService.getProduct(id);
        return new Page("product_edit.jsp").data("product", product);
    }

    @Request("post:/product/create")
    public Result create(Map<String, Object> fieldMap, Multipart multipart) {
        boolean success = productService.createProduct(fieldMap);
        if (success) {
            String basePath = DataContext.getServletContext().getRealPath("") + Constant.UPLOAD_PATH;
            UploadHelper.upload(basePath, multipart);
        }
        return new Result(success);
    }

    @Request("put:/product/update/{id}")
    public Result update(long id, Map<String, Object> fieldMap) {
        boolean success = productService.updateProduct(id, fieldMap);
        return new Result(success);
    }

    @Request("post:/product/upload/{id}")
    public Result upload(long id, Map<String, Object> fieldMap, Multipart multipart) {
        boolean success = productService.updateProduct(id, fieldMap);
        if (success) {
            String basePath = DataContext.getServletContext().getRealPath("") + Constant.UPLOAD_PATH;
            UploadHelper.upload(basePath, multipart);
        }
        return new Result(success).data(multipart.getFileName());
    }

    @Request("delete:/product/delete/{id}")
    public Result delete(long id) {
        boolean success = productService.deleteProduct(id);
        return new Result(success);
    }
}
