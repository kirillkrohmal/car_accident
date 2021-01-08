package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Role;
import ru.job4j.accident.model.User;

@Repository
public class UserRepository {
    private final SessionFactory sessionFactory;
    private static final String ROLE_USER = "ROLE_USER";

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User save(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.save(user);
            Role role = new Role(ROLE_USER);
            role.setUser(user);
            session.saveOrUpdate(role);
            return user;
        }
    }
}
