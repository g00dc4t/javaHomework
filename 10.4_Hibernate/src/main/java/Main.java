import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {

    public static SessionFactory getSessionFactory() {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;
    }

    public static void main(String[] args) {
        try {
            Session session = getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);
            Root<PurchaseList> root = query.from(PurchaseList.class);
            query.select(root);
            List<PurchaseList> results = session.createQuery(query).getResultList();

            for (PurchaseList purchase : results) {
                String studentName = purchase.getPurchaseListKey().getStudent();
                String courseName = purchase.getPurchaseListKey().getCourse();
                Integer studentId = (Integer) session
                        .createQuery("SELECT id FROM Student WHERE name = '" + studentName + "'")
                        .getResultList().get(0);
                Integer courseId = (Integer) session
                        .createQuery("SELECT id FROM Course WHERE name = '" + courseName + "'")
                        .getResultList().get(0);
                LinkedPurchaseListKey linkedPurchaseListKey = new LinkedPurchaseListKey(studentId, courseId);
                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                linkedPurchaseList.setLinkedPurchaseListKey(linkedPurchaseListKey);
                session.save(linkedPurchaseList);
            }

            transaction.commit();
            session.close();

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
