import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        SimpleDateFormat formatRegistrationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Student student = session.get(Student.class, 1);
        System.out.println("Имя студента: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Дата регистрации: " + student.getRegistrationDate());
        System.out.println(formatRegistrationDate.format(student.getRegistrationDate()));
        sessionFactory.close();

    }
}
