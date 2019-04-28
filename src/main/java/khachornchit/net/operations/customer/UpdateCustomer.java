package khachornchit.net.operations.customer;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import khachornchit.net.entity.Customer;

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
		customers.add(new Customer("PENELOPE", "GUINESS", "penelope_guiness@pluto.solutions"));
		customers.add(new Customer("NICK", "WAHLBERG", "nick_washlberg@pluto.solutions"));
		customers.add(new Customer("ED", "CHASE", "ed_chase@pluto.solutions"));
		customers.add(new Customer("JENNIFER", "DAVIS", "jenifer_davis@pluto.solutions"));
		customers.add(new Customer("JOHNNY", "LOLLOBRIGIDA", "johny_lollobrigida@pluto.solutions"));
		customers.add(new Customer("BETTE", "NICHOLSON", "better_nicholson@pluto.solutions"));
		customers.add(new Customer("GRACE", "MOSTEL", "grace_mostel@pluto.solutions"));
		customers.add(new Customer("MATTHEW", "JOHANSSON", "matthew_johansson@pluto.solutions"));
		customers.add(new Customer("JOE", "SWANK", "joe_swank@pluto.solutions"));
		customers.add(new Customer("CHRISTIAN", "GABLE", "christian_gabble@pluto.solutions"));
		customers.add(new Customer("ZERO", "CAGE", "zero_cage@pluto.solutions"));
		customers.add(new Customer("KARL", "BERRY", "karl_berry@pluto.solutions"));
		customers.add(new Customer("UMA", "WOOD", "uma_wood@pluto.solutions"));
		customers.add(new Customer("VIVIEN", "BERGEN", "vivien_bergen@pluto.solutions"));
		customers.add(new Customer("CUBA", "OLIVIER", "cuba_oliver@pluto.solutions"));
		customers.add(new Customer("FRED", "COSTNER", "fred_costner@pluto.solutions"));
		customers.add(new Customer("HELEN", "VOIGHT", "helen_voight@pluto.solutions"));
		customers.add(new Customer("DAN", "TORN", "dan_torn@pluto.solutions"));
		return customers;
	}

}
