package org.smart4j.sample.rest;

import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.smart4j.plugin.rest.Rest;
import org.smart4j.sample.entity.Product;

@Rest
@Path("/ProductService")
public interface ProductService {

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> getProductList();

    @GET
    @Path("/product/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    Product getProduct(@PathParam("productId") long productId);

    @POST
    @Path("/product")
    @Consumes(MediaType.APPLICATION_JSON)
    boolean createProduct(Map<String, Object> productFieldMap);

    @PUT
    @Path("/product/{productId}")
    @Consumes(MediaType.APPLICATION_JSON)
    boolean updateProduct(@PathParam("productId") long productId, Map<String, Object> productFieldMap);

    @DELETE
    @Path("/product/{productId}")
    boolean deleteProduct(@PathParam("productId") long productId);
}
