package com.smart.sample.action;

import com.smart.framework.DataContext;
import com.smart.framework.annotation.Action;
import com.smart.framework.annotation.Inject;
import com.smart.framework.annotation.Request;
import com.smart.framework.bean.Multipart;
import com.smart.framework.bean.Multiparts;
import com.smart.framework.bean.Pager;
import com.smart.framework.bean.Param;
import com.smart.framework.bean.Result;
import com.smart.framework.bean.View;
import com.smart.framework.util.WebUtil;
import com.smart.sample.Constant;
import com.smart.sample.Tool;
import com.smart.sample.bean.ProductBean;
import com.smart.sample.entity.Product;
import com.smart.sample.entity.ProductType;
import com.smart.sample.service.ProductService;
import java.util.List;
import java.util.Map;

@Action
public class ProductAction {

    @Inject
    private ProductService productService;

    @Request.Get("/product")
    public View index() {
        int pageNumber = 1;
        int pageSize = Tool.getPageSize("product_pager");
        String name = "";

        Pager<ProductBean> productBeanPager = productService.getProductBeanPager(pageNumber, pageSize, name);
        return new View("product.jsp")
            .data("productBeanPager", productBeanPager);
    }

    @Request.Post("/product/search")
    public View search(Param param) {
        int pageNumber = param.getInt(Constant.PAGE_NUMBER);
        int pageSize = param.getInt(Constant.PAGE_SIZE);
        String name = param.getString("name");

        Pager<ProductBean> productBeanPager = productService.getProductBeanPager(pageNumber, pageSize, name);
        return new View("product_list.jsp")
            .data("productBeanPager", productBeanPager);
    }

    @Request.Get("/product/create")
    public View create() {
        List<ProductType> productTypeList = productService.getProductTypeList();
        return new View("product_create.jsp")
            .data("productTypeList", productTypeList);
    }

    @Request.Post("/product/create")
    public Result create(Param param, Multiparts multiparts) {
        Map<String, Object> fieldMap = param.getFieldMap();
        Multipart multipart = multiparts.getOne();
        boolean success = productService.createProduct(fieldMap, multipart);
        return new Result(success);
    }

    @Request.Delete("/product/delete/{id}")
    public Result delete(long id) {
        boolean success = productService.deleteProduct(id);
        return new Result(success);
    }

    @Request.Get("/product/view/{id}")
    public View view(long id) {
        ProductBean productBean = productService.getProductBean(id);
        return new View("product_view.jsp")
            .data("productBean", productBean);
    }

    @Request.Get("/product/edit/{id}")
    public View edit(long id) {
        List<ProductType> productTypeList = productService.getProductTypeList();
        ProductBean productBean = productService.getProductBean(id);
        return new View("product_edit.jsp")
            .data("productTypeList", productTypeList)
            .data("productBean", productBean);
    }

    @Request.Put("/product/update/{id}")
    public Result update(long id, Param param) {
        Map<String, Object> fieldMap = param.getFieldMap();
        boolean success = productService.updateProduct(id, fieldMap, null);
        return new Result(success);
    }

    @Request.Get("/product/upload_picture/{id}")
    public View uploadPicture(long id) {
        Product product = productService.getProduct(id);
        return new View("product_upload.jsp")
            .data("product", product);
    }

    @Request.Post("/product/upload_picture/{id}")
    public Result uploadPicture(long id, Param param, Multiparts multiparts) {
        Map<String, Object> fieldMap = param.getFieldMap();
        Multipart multipart = multiparts.getOne();
        boolean success = productService.updateProduct(id, fieldMap, multipart);
        return new Result(success)
            .data(multipart.getFileName());
    }

    @Request.Get("/product/download_picture/{id}")
    public void downloadPicture(long id) {
        Product product = productService.getProduct(id);
        String picture = product.getPicture();

        String filePath = Tool.getBasePath() + picture;
        WebUtil.downloadFile(DataContext.getResponse(), filePath);
    }
}
