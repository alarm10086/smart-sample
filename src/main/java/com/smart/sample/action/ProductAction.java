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
import com.smart.framework.util.CastUtil;
import com.smart.framework.util.FileUtil;
import com.smart.sample.Tool;
import com.smart.sample.bean.ProductBean;
import com.smart.sample.entity.Product;
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
        int pageSize = Tool.getPageSize();
        String name = "";

        Pager<ProductBean> productBeanPager = productService.getProductBeanPager(pageNumber, pageSize, name);
        return new Page("product.jsp")
            .data("productBeanPager", productBeanPager);
    }

    @Request("POST:/product/search")
    public Page search(Map<String, Object> fieldMap) {
        int pageNumber = CastUtil.castInt(fieldMap.get(PAGE_NUMBER));
        int pageSize = CastUtil.castInt(fieldMap.get(PAGE_SIZE));
        String name = CastUtil.castString(fieldMap.get("name"));

        Pager<ProductBean> productBeanPager = productService.getProductBeanPager(pageNumber, pageSize, name);
        return new Page("product_list.jsp")
            .data("productBeanPager", productBeanPager);
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
            String filePath = Tool.getBasePath() + multipart.getFileName();
            FileUtil.uploadFile(filePath, multipart.getInputStream());
        }
        return new Result(success);
    }

    @Request("DELETE:/product/delete/{id}")
    public Result delete(long id) {
        boolean success = productService.deleteProduct(id);
        return new Result(success);
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

    @Request("PUT:/product/update/{id}")
    public Result update(long id, Map<String, Object> fieldMap) {
        boolean success = productService.updateProduct(id, fieldMap);
        return new Result(success);
    }

    @Request("GET:/product/upload_picture/{id}")
    public Page uploadPicture(long id) {
        Product product = productService.getProduct(id);
        return new Page("product_upload.jsp")
            .data("product", product);
    }

    @Request("POST:/product/upload_picture/{id}")
    public Result uploadPicture(long id, Map<String, Object> fieldMap, Multipart multipart) {
        boolean success = productService.updateProduct(id, fieldMap);
        if (success) {
            String filePath = Tool.getBasePath() + multipart.getFileName();
            FileUtil.uploadFile(filePath, multipart.getInputStream());
        }
        return new Result(success)
            .data(multipart.getFileName());
    }

    @Request("GET:/product/download_picture/{id}")
    public void downloadPicture(long id) {
        Product product = productService.getProduct(id);
        String picture = product.getPicture();

        String filePath = Tool.getBasePath() + picture;
        FileUtil.downloadFile(filePath, DataContext.getResponse());
    }
}
