import data.entity.Actor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import util.HibernateUtil;


public class CreateTest {
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
    public void actorCreate() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Actor actor = new Actor();
        actor.setFirstName("Şener");
        actor.setLastName("Şen");
        session.save(actor);
        transaction.commit();
        session.close();
    }
}
