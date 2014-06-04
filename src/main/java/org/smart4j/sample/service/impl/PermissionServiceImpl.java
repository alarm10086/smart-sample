package org.smart4j.sample.service.impl;

import java.util.List;
import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;
import org.smart4j.sample.entity.Permission;
import org.smart4j.sample.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Override
    public List<Permission> getPermissionList() {
        return DataSet.selectList(Permission.class);
    }
}
