package khachornchit.net.operations.customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import khachornchit.net.entity.Customer;

public class DeleteCustomer {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		try {
			Session session = factory.getCurrentSession();
			
			System.out.println("Start transaction ...");
			session.beginTransaction();
//			Customer customer = session.get(Customer.class, 3);
//			session.delete(customer);
			session.createQuery("delete from Customer where id=5").executeUpdate();
			session.getTransaction().commit();
			
			System.out.println("Commited done !");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
