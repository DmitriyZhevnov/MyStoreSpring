package ru.zhevnov.myStore.dao;

import org.hibernate.Session;
import ru.zhevnov.myStore.model.Role;

public interface IRoleDao {
    public Role returnUserValue();
    public void addNewRole(String name);
}
