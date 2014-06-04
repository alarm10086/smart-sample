package org.smart4j.sample.service.impl;

import java.util.List;
import org.smart4j.framework.orm.DataSet;
import org.smart4j.framework.tx.annotation.Service;
import org.smart4j.sample.entity.Role;
import org.smart4j.sample.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public List<Role> getRoleList() {
        return DataSet.selectList(Role.class);
    }
}
