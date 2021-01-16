package ru.zhevnov.myStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zhevnov.myStore.dao.IRoleDao;
import ru.zhevnov.myStore.model.Role;

@Service
public class RoleService implements IRoleService{

    @Autowired
    private IRoleDao roleDao;

    @Override
    public Role returnUserValue() {
        return roleDao.returnUserValue();
    }

    @Override
    public void addNewRole(String name) {
        roleDao.addNewRole(name);
    }
}
