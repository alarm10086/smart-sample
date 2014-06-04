package org.smart4j.sample.entity;

import org.smart4j.framework.orm.annotation.Entity;

@Entity
public class Permission {

    private long id;

    private String permissionName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
