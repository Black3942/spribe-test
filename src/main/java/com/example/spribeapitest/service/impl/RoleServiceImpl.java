package com.example.spribeapitest.service.impl;

import com.example.spribeapitest.dao.RoleDao;
import com.example.spribeapitest.exception.DataProcessingException;
import com.example.spribeapitest.model.Role;
import com.example.spribeapitest.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName).orElseThrow(() ->
                new DataProcessingException("Can't find role " + roleName));
    }
}
