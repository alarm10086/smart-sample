package com.smart.sample.action;

import com.smart.framework.DataContext;
import com.smart.framework.annotation.Action;
import com.smart.framework.annotation.Inject;
import com.smart.framework.annotation.Request;
import com.smart.framework.bean.Multipart;
import com.smart.framework.bean.Multiparts;
import com.smart.framework.bean.Page;
import com.smart.framework.bean.Pager;
import com.smart.framework.bean.Result;
import com.smart.framework.util.CastUtil;
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
    public Page index() {
        int pageNumber = 1;
        int pageSize = Tool.getPageSize("product_pager");
        String name = "";

        Pager<ProductBean> productBeanPager = productService.getProductBeanPager(pageNumber, pageSize, name);
        return new Page("product.jsp")
            .data("productBeanPager", productBeanPager);
    }

    @Request.Post("/product/search")
    public Page search(Map<String, Object> fieldMap) {
        int pageNumber = CastUtil.castInt(fieldMap.get(Constant.PAGE_NUMBER));
        int pageSize = CastUtil.castInt(fieldMap.get(Constant.PAGE_SIZE));
        String name = CastUtil.castString(fieldMap.get("name"));

        Pager<ProductBean> productBeanPager = productService.getProductBeanPager(pageNumber, pageSize, name);
        return new Page("product_list.jsp")
            .data("productBeanPager", productBeanPager);
    }

    @Request.Get("/product/create")
    public Page create() {
        List<ProductType> productTypeList = productService.getProductTypeList();
        return new Page("product_create.jsp")
            .data("productTypeList", productTypeList);
    }

    @Request.Post("/product/create")
    public Result create(Map<String, Object> fieldMap, Multiparts multiparts) {
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
    public Page view(long id) {
        ProductBean productBean = productService.getProductBean(id);
        return new Page("product_view.jsp")
            .data("productBean", productBean);
    }

    @Request.Get("/product/edit/{id}")
    public Page edit(long id) {
        List<ProductType> productTypeList = productService.getProductTypeList();
        ProductBean productBean = productService.getProductBean(id);
        return new Page("product_edit.jsp")
            .data("productTypeList", productTypeList)
            .data("productBean", productBean);
    }

    @Request.Put("/product/update/{id}")
    public Result update(long id, Map<String, Object> fieldMap) {
        boolean success = productService.updateProduct(id, fieldMap, null);
        return new Result(success);
    }

    @Request.Get("/product/upload_picture/{id}")
    public Page uploadPicture(long id) {
        Product product = productService.getProduct(id);
        return new Page("product_upload.jsp")
            .data("product", product);
    }

    @Request.Post("/product/upload_picture/{id}")
    public Result uploadPicture(long id, Map<String, Object> fieldMap, Multiparts multiparts) {
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
