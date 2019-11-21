package net.putfirstthingsfirst.operation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.putfirstthingsfirst.entity.Customer;

public class QueryCustomer {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();

		try {
			Session session = factory.getCurrentSession();

			System.out.println("Read customer ...");
			session.beginTransaction();

			System.out.println("c.firstName='Paul1' OR c.lastName='Hibernate' ...");
			List<Customer> customers = session
					.createQuery("from Customer c where c.firstName like 'J%' OR c.lastName like 'D%'").getResultList();
			customers.forEach(x -> System.out.println(x.toString()));
			
			System.out.println();
			System.out.println("where firstName like 'M%'");
			customers = session.createQuery("from Customer c where c.firstName like 'M%'").list();
			customers.forEach(x -> System.out.println(x.toString()));
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
