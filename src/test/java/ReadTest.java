import data.entity.Actor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import util.HibernateUtil;

import java.util.List;

public class ReadTest {
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void setUp() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @AfterClass
    public static void tearDown() {
        if (sessionFactory != null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }

    @Test
    public void actor() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Actor> query = session.createQuery("from Actor where id > :id", Actor.class);
        query.setParameter("id", (short) 195);
        List<Actor> actors = query.list();

        for(Actor actor: actors) {
            System.out.println(actor);
        }

        transaction.commit();
        session.close();
    }
}
