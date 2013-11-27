package com.smart.sample.ws.rest;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Bean;
import com.smart.framework.base.BaseService;
import com.smart.plugin.ws.RESTHelper;
import com.smart.plugin.ws.WebService;
import com.smart.sample.entity.Product;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Bean
@WebService(type = WebService.Type.REST)
public class ProductService extends BaseService {

    @GET
    @Path("/products")
    public Response getProductList() {
        List<Product> productList = DataSet.selectList(Product.class, "", "id asc");
        return RESTHelper.createJsonResponse(productList);
    }

    @GET
    @Path("/product/{productId}")
    public Response getProduct(@PathParam("productId") long productId) {
        Product product = DataSet.select(Product.class, "id = ?", productId);
        return RESTHelper.createJsonResponse(product);
    }
}
