package Hibernate.Operation.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Hibernate.Entity.Customer;

public class CreateCustomer {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		try {
			Session session = factory.getCurrentSession();
			
			System.out.println("Start transaction ...");
			session.beginTransaction();
			for (int i = 0; i < 18; i++) {
				String firstName = "firstname " + i;
				String lastName = "lastname " + i;
				String email = String.format("%s_%s@test.com", firstName, lastName);

				session.save(new Customer(firstName, lastName, email));
			}
			session.getTransaction().commit();
			
			System.out.println("Commited done !");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
