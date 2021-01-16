package ru.zhevnov.myStore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.zhevnov.myStore.model.Role;

@Repository
public class RoleDao implements IRoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Role returnUserValue(){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Role roleUser = session.get(Role.class, 2);
            session.getTransaction().commit();
            //System.out.println(roleUser);
            return roleUser;
        }
    }
    public void addNewRole(String name){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Role roleUser = new Role(name);
            session.save(roleUser);
            session.getTransaction().commit();
            System.out.println(roleUser);
        }
    }
}
