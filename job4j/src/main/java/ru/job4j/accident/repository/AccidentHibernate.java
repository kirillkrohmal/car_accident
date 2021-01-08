package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;

@Repository
public class AccidentHibernate {
    private final SessionFactory sessionFactory;

    public AccidentHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Accident save(Accident accident) {
        try (Session session = sessionFactory.openSession()) {
            session.save(accident);
            return accident;
        }
    }

    public List<Accident> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Accident", Accident.class).list();
        }
    }
}
