package com.smart.sample.entity;

import com.smart.framework.base.BaseEntity;

public class Customer extends BaseEntity {

    private String customerName;

    private String description;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
