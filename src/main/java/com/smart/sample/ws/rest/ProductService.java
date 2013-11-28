package com.smart.sample.ws.rest;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Bean;
import com.smart.framework.base.BaseService;
import com.smart.plugin.ws.RESTHelper;
import com.smart.plugin.ws.WebService;
import com.smart.sample.entity.Product;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
        return RESTHelper.createResponse(productList);
    }

    @GET
    @Path("/product/{product_id}")
    public Response getProduct(
        @PathParam("product_id") long productId
    ) {
        Product product = DataSet.select(Product.class, "id = ?", productId);
        return RESTHelper.createResponse(product);
    }

    @POST
    @Path("/product")
    public Response createProduct(Map<String, Object> fieldMap) {
        // TODO 无法转换参数
        boolean result = DataSet.insert(Product.class, fieldMap);
        return RESTHelper.createResponse(result);
    }
}
