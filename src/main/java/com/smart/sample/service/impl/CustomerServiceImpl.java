package com.smart.sample.service.impl;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Bean;
import com.smart.framework.base.BaseService;
import com.smart.sample.entity.Customer;
import com.smart.sample.service.CustomerService;
import java.util.List;
import java.util.Map;

@Bean
public class CustomerServiceImpl extends BaseService implements CustomerService {

    @Override
    public List<Customer> getCustomerList() {
        return DataSet.selectList(Customer.class, "", "id desc");
    }

    @Override
    public List<Customer> getCustomerList(String customerName) {
        return DataSet.selectList(Customer.class, "customer_name like ?", "id desc", '%' + customerName + '%');
    }

    @Override
    public boolean deleteCustomer(long id) {
        return DataSet.delete(Customer.class, "id = ?", id);
    }

    @Override
    public Customer getCustomer(long id) {
        return DataSet.select(Customer.class, "id = ?", id);
    }

    @Override
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DataSet.update(Customer.class, fieldMap, "id = ?", id);
    }

    @Override
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DataSet.insert(Customer.class, fieldMap);
    }
}
