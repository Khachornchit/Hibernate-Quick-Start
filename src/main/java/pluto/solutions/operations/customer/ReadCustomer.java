package pluto.solutions.operations.customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pluto.solutions.entity.Customer;

public class ReadCustomer {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();

		try {
			Session session = factory.getCurrentSession();

			System.out.println("Read customer ...");
			session.beginTransaction();
			Customer customer = session.get(Customer.class, 5);			
			System.out.println(customer.toString());
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
