package smart.sample.entity;

import smart.framework.base.BaseEntity;

public class ProductType extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
