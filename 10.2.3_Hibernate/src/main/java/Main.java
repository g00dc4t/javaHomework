import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

    public static SessionFactory getSessionFactory() {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;
    }

    public static void main(String[] args) {

        Session session = getSessionFactory().openSession();

        //10.2
//        Course course = session.get(Course.class, 1);
//        System.out.println(course.getName() + " - " + course.getStudentCount());

        //10.3
        Course course = session.get(Course.class, 1);
        Student student = session.get(Student.class, 1);
        SubscriptionID subscriptionID = new SubscriptionID();
        subscriptionID.setCourse(course);
        subscriptionID.setStudent(student);

        Subscription subscription = new Subscription();
        subscription.setSubscriptionID(subscriptionID);

        System.out.println(subscription);

        session.close();
    }
}
