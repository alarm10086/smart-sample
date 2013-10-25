package com.smart.sample.service.impl;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Bean;
import com.smart.framework.base.BaseService;
import com.smart.framework.util.CollectionUtil;
import com.smart.plugin.cache.Cache;
import com.smart.plugin.cache.CacheManager;
import com.smart.plugin.cache.impl.DefaultCacheManager;
import com.smart.sample.entity.Customer;
import com.smart.sample.service.CustomerService;
import java.util.List;
import java.util.Map;

@Bean
public class CustomerServiceCacheImpl extends BaseService implements CustomerService {

    private static final CacheManager cacheManager = new DefaultCacheManager("customer_list_cache", "customer_cache");
    private static final Cache<String, List<Customer>> customerListCache = cacheManager.getCache("customer_list_cache");
    private static final Cache<Long, Customer> customerCache = cacheManager.getCache("customer_cache");

    @Override
    public List<Customer> getCustomerList() {
        List<Customer> customerList = customerListCache.get("customer_list");
        if (customerList == null) {
            customerList = DataSet.selectList(Customer.class, null, null);
            if (CollectionUtil.isNotEmpty(customerList)) {
                customerListCache.put("customer_list", customerList);
            }
        }
        return customerList;
    }

    @Override
    public boolean deleteCustomer(long id) {
        boolean result = DataSet.delete(Customer.class, "id = ?", id);
        if (result) {
            customerListCache.clear();
            customerCache.remove(id);
        }
        return result;
    }

    @Override
    public Customer getCustomer(long id) {
        Customer customer = customerCache.get(id);
        if (customer == null) {
            customer = DataSet.select(Customer.class, "id = ?", id);
            if (customer != null) {
                customerCache.put(id, customer);
            }
        }
        return customer;
    }

    @Override
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        boolean result = DataSet.update(Customer.class, fieldMap, "id = ?", id);
        if (result) {
            for (String cacheName : cacheManager.getCacheNames()) {
                cacheManager.destroyCache(cacheName);
            }
        }
        return result;
    }

    @Override
    public boolean createCustomer(Map<String, Object> fieldMap) {
        boolean result = DataSet.insert(Customer.class, fieldMap);
        if (result) {
            for (String cacheName : cacheManager.getCacheNames()) {
                cacheManager.destroyCache(cacheName);
            }
        }
        return result;
    }
}
