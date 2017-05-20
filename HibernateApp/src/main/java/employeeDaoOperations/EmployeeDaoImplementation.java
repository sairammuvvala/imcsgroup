package employeeDaoOperations;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import employeeUtils.HibernateUtil;
import pojo.Employee;

public class EmployeeDaoImplementation implements EmployeeDaoInterface {

	SessionFactory sf;

	public EmployeeDaoImplementation() {
		sf = HibernateUtil.getSessionFactory();
	}


	public boolean save(Employee employee) {
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.save(employee);
		}catch(Exception e){
			return false;
		}
		transaction.commit();
		session.close();
		return true;
	}

	public Employee get(int id) throws SQLException {
		// TODO Auto-generated method stub
		sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		Employee employee = (Employee) session.get(Employee.class, id);

		session.getTransaction().commit();
		session.close();
		return employee;
	}

	public List<Employee> getAll() throws SQLException {
		sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		
		List<Employee> employees = criteria.list();
		session.close();
		return employees;

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

	public boolean update(Employee employee) throws SQLException{
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.update(employee);
		}catch(Exception e){
			return false;
		}
		transaction.commit();
		session.close();
		return true;
	}
	
}
