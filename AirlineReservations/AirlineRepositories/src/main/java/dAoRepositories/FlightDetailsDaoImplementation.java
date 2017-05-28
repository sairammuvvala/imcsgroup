package dAoRepositories;

import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Flight_details;
import utils.HibernateUtil;

public class FlightDetailsDaoImplementation implements FlightDaoDetailInterface {
	
	SessionFactory sf;

	public FlightDetailsDaoImplementation() {
		sf = HibernateUtil.getSessionFactory();
	}

	public boolean save(Flight_details flight) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.save(flight);
		}catch(Exception e){
			return false;
		}
		transaction.commit();
		session.close();
		return true;
	}

	public Flight_details get(int id) throws SQLException {
		sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		Flight_details flight = (Flight_details) session.get(Flight_details.class, id);

		session.getTransaction().commit();
		session.close();
		return flight;
	}

	public boolean delete(int id) throws SQLException {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "delete Employee where id = :id";
		try{
			Query query = session.createQuery(hql).setParameter("id", id);
			query.executeUpdate();
		}catch(Exception e){
			return false;
		}
		transaction.commit();
		session.close();
		return true;
	}

	public boolean update(Flight_details flight) throws SQLException {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.update(flight);
		}catch(Exception e){
			return false;
		}
		transaction.commit();
		session.close();
		return true;
	}

}
