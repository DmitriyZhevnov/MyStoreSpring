package ru.zhevnov.myStore.service;

import ru.zhevnov.myStore.model.Role;

public interface IRoleService {
    public Role returnUserValue();
    public void addNewRole(String name);
}
