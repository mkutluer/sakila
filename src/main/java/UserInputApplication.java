import data.entity.Actor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;
import java.util.Scanner;

public class UserInputApplication {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query<Actor> query = session.createQuery("from Actor where id > :id", Actor.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter user lower id limit:");
        short id = scanner.nextShort();
        scanner.close();
        query.setParameter("id", id);
        List<Actor> actors = query.list();

        for(Actor actor: actors) {
            System.out.println(actor);
        }

        transaction.commit();
        session.close();
    }

}
