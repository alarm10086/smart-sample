package com.smart.sample.entity;

import com.smart.framework.base.BaseEntity;

public class Customer extends BaseEntity {

    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
