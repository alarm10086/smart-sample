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
import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;
import org.smart4j.framework.tx.annotation.Transaction;
import org.smart4j.plugin.rest.Rest;
import org.smart4j.sample.entity.Product;

@Service
@Rest("/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductService {

    @GET
    @Path("/products")
    public List<Product> getProductList() {
        return DataSet.selectListWithSort(Product.class, "id asc");
    }

    @GET
    @Path("/product/{productId}")
    public Product getProduct(@PathParam("productId") long productId) {
        return DataSet.select(Product.class, "id = ?", productId);
    }

    @POST
    @Path("/product")
    @Transaction
    public boolean createProduct(Map<String, Object> productFieldMap) {
        return DataSet.insert(Product.class, productFieldMap);
    }

    @PUT
    @Path("/product/{productId}")
    @Transaction
    public boolean updateProduct(@PathParam("productId") long productId, Map<String, Object> productFieldMap) {
        return DataSet.update(Product.class, productFieldMap, "id = ?", productId);
    }

    @DELETE
    @Path("/product/{productId}")
    @Transaction
    public boolean deleteProduct(@PathParam("productId") long productId) {
        return DataSet.delete(Product.class, "id = ?", productId);
    }
}
