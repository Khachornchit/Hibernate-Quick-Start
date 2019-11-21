package net.putfirstthingsfirst.operation;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.putfirstthingsfirst.entity.Customer;

public class UpdateCustomer {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();

		try {
			Session session = factory.getCurrentSession();

			System.out.println("Start update ...");
			session.beginTransaction();
			List<Customer> customers = session.createQuery("from Customer c").list();
			List<Customer> initCustomers = InitCustomer();

			for (int i = 0; i < customers.size(); i++) {
				customers.get(i).setFirstName(initCustomers.get(i).getFirstName());
				customers.get(i).setLastName(initCustomers.get(i).getLastName());
				customers.get(i).setEmail(initCustomers.get(i).getEmail());
			}

			session.createQuery("update Customer set email='hello@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Updated completed !!!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static List<Customer> InitCustomer() {
		List<Customer> customers = new LinkedList<Customer>();
		customers.add(new Customer("PENELOPE", "GUINESS", "penelope_guiness@test.com"));
		customers.add(new Customer("NICK", "WAHLBERG", "nick_washlberg@test.com"));
		customers.add(new Customer("ED", "CHASE", "ed_chase@test.com"));
		customers.add(new Customer("JENNIFER", "DAVIS", "jenifer_davis@test.com"));
		customers.add(new Customer("JOHNNY", "LOLLOBRIGIDA", "johny_lollobrigida@test.com"));
		customers.add(new Customer("BETTE", "NICHOLSON", "better_nicholson@test.com"));
		customers.add(new Customer("GRACE", "MOSTEL", "grace_mostel@test.com"));
		customers.add(new Customer("MATTHEW", "JOHANSSON", "matthew_johansson@test.com"));
		customers.add(new Customer("JOE", "SWANK", "joe_swank@test.com"));
		customers.add(new Customer("CHRISTIAN", "GABLE", "christian_gabble@test.com"));
		customers.add(new Customer("ZERO", "CAGE", "zero_cage@test.com"));
		customers.add(new Customer("KARL", "BERRY", "karl_berry@test.com"));
		customers.add(new Customer("UMA", "WOOD", "uma_wood@test.com"));
		customers.add(new Customer("VIVIEN", "BERGEN", "vivien_bergen@test.com"));
		customers.add(new Customer("CUBA", "OLIVIER", "cuba_oliver@test.com"));
		customers.add(new Customer("FRED", "COSTNER", "fred_costner@test.com"));
		customers.add(new Customer("HELEN", "VOIGHT", "helen_voight@test.com"));
		customers.add(new Customer("DAN", "TORN", "dan_torn@test.com"));
		return customers;
	}

}
