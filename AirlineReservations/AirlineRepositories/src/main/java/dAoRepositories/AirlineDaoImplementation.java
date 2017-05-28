package dAoRepositories;

import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Flight;
import utils.HibernateUtil;


public class AirlineDaoImplementation implements AirlineDaoInterface {
	
	SessionFactory sf;

	public AirlineDaoImplementation() {
		sf = HibernateUtil.getSessionFactory();
	}

	public boolean save(Flight flight) {
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

	public Flight get(int id) throws SQLException {
		sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		Flight flight = (Flight) session.get(Flight.class, id);

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

	public boolean update(Flight flight) throws SQLException {
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
