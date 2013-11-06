package com.smart.sample.service.impl;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Bean;
import com.smart.framework.base.BaseService;
import com.smart.plugin.cache.annotation.Cachable;
import com.smart.plugin.cache.annotation.CacheClear;
import com.smart.plugin.cache.annotation.CachePut;
import com.smart.sample.entity.Customer;
import com.smart.sample.service.CustomerService;
import java.util.List;
import java.util.Map;

@Bean
@Cachable
public class CustomerServiceCacheAnnotationImpl extends BaseService implements CustomerService {

    @Override
    @CachePut("customer_list_cache")
    public List<Customer> getCustomerList() {
        return DataSet.selectList(Customer.class, "", "");
    }

    @Override
    @CacheClear({"customer_list_cache", "customer_cache"})
    public boolean deleteCustomer(long id) {
        return DataSet.delete(Customer.class, "id = ?", id);
    }

    @Override
    @CachePut("customer_cache")
    public Customer getCustomer(long id) {
        return DataSet.select(Customer.class, "id = ?", id);
    }

    @Override
    @CacheClear({"customer_list_cache", "customer_cache"})
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DataSet.update(Customer.class, fieldMap, "id = ?", id);
    }

    @Override
    @CacheClear({"customer_list_cache", "customer_cache"})
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DataSet.insert(Customer.class, fieldMap);
    }
}
