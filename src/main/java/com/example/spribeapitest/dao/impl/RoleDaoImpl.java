package com.example.spribeapitest.dao.impl;

import com.example.spribeapitest.dao.AbstractDao;
import com.example.spribeapitest.dao.RoleDao;
import com.example.spribeapitest.model.Role;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(String name) {
        try (Session session = factory.openSession()) {
            Query<Role> findByName = session.createQuery(
                    "SELECT r from Role r where r.role = :role", Role.class);
            return findByName.setParameter("role", name).uniqueResultOptional();
        }
    }
}
