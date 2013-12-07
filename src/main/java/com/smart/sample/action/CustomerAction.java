package com.smart.sample.action;

import com.smart.framework.DataContext;
import com.smart.framework.annotation.Bean;
import com.smart.framework.annotation.Inject;
import com.smart.framework.annotation.Request;
import com.smart.framework.base.BaseAction;
import com.smart.framework.bean.Multipart;
import com.smart.framework.bean.Page;
import com.smart.framework.bean.Result;
import com.smart.framework.helper.UploadHelper;
import com.smart.sample.Constant;
import com.smart.sample.entity.Customer;
import com.smart.sample.service.CustomerService;
import java.util.List;
import java.util.Map;

@Bean
public class CustomerAction extends BaseAction {

    @Inject
    private CustomerService customerService;

    @Request("get:/customer")
    public Page index() {
        List<Customer> customerList = customerService.getCustomerList();
        return new Page("customer.jsp").data("customerList", customerList);
    }

    @Request("get:/customer/view/{id}")
    public Page view(long id) {
        Customer customer = customerService.getCustomer(id);
        return new Page("customer_view.jsp").data("customer", customer);
    }

    @Request("get:/customer/edit/{id}")
    public Page edit(long id) {
        Customer customer = customerService.getCustomer(id);
        return new Page("customer_edit.jsp").data("customer", customer);
    }

    @Request("post:/customer/create")
    public Result create(Map<String, Object> fieldMap, Multipart multipart) {
        boolean success = customerService.createCustomer(fieldMap);
        if (success) {
            String basePath = DataContext.getServletContext().getRealPath("") + Constant.UPLOAD_PATH;
            UploadHelper.upload(basePath, multipart);
        }
        return new Result(success);
    }

    @Request("put:/customer/update/{id}")
    public Result update(long id, Map<String, Object> fieldMap) {
        boolean success = customerService.updateCustomer(id, fieldMap);
        return new Result(success);
    }

    @Request("post:/customer/upload/{id}")
    public Result upload(long id, Map<String, Object> fieldMap, Multipart multipart) {
        boolean success = customerService.updateCustomer(id, fieldMap);
        if (success) {
            String basePath = DataContext.getServletContext().getRealPath("") + Constant.UPLOAD_PATH;
            UploadHelper.upload(basePath, multipart);
        }
        return new Result(success).data(multipart.getFileName());
    }

    @Request("delete:/customer/delete/{id}")
    public Result delete(long id) {
        boolean success = customerService.deleteCustomer(id);
        return new Result(success);
    }
}
