import data.entity.Actor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import util.HibernateUtil;


public class UpdateTest {
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
    public void actorUpdateModel() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Actor actor = session.get(Actor.class, (short) 2);
        actor.setFirstName("Ali Şener");
        session.save(actor);

        System.out.println(actor);

        transaction.commit();
        session.close();
    }

    @Test
    public void actorUpdateHQL() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Actor set firstName=:firstName where id=:id");
        query.setParameter("id", (short) 1);
        query.setParameter("firstName", "Ali");
        int result = query.executeUpdate();
        System.out.println("Affected row count: " + result);

        Actor actor = session.get(Actor.class, (short) 1);
        System.out.println(actor);

        transaction.commit();
        session.close();
    }
}
