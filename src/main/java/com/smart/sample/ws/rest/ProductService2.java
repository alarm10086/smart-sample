package com.smart.sample.ws.rest;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Bean;
import com.smart.framework.base.BaseService;
import com.smart.plugin.ws.WebService;
import com.smart.sample.entity.Product;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Bean
@WebService(type = WebService.Type.REST)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductService2 extends BaseService {

    @GET
    @Path("/products")
    public List<Product> getProductList() {
        return DataSet.selectList(Product.class, "", "id asc");
    }

    @GET
    @Path("/product/{productId}")
    public Product getProduct(@PathParam("productId") long productId) {
        return DataSet.select(Product.class, "id = ?", productId);
    }
}
