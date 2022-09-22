package com.allinone.MyHibernateProject.northwind.dao;
// Generated 11 sept. 2022 14:01:17 by Hibernate Tools 5.6.9.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.allinone.MyHibernateProject.northwind.entity.Employees;

/**
 * Home object for domain model class Employees.
 * @see com.allinone.MyHibernateProject.northwind.dao.Employees
 * @author Hibernate Tools
 */
public class EmployeesHome {

	private static final Logger logger = Logger.getLogger(EmployeesHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Employees transientInstance) {
		logger.log(Level.INFO, "persisting Employees instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Employees instance) {
		logger.log(Level.INFO, "attaching dirty Employees instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(Employees instance) {
		logger.log(Level.INFO, "attaching clean Employees instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(Employees persistentInstance) {
		logger.log(Level.INFO, "deleting Employees instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public Employees merge(Employees detachedInstance) {
		logger.log(Level.INFO, "merging Employees instance");
		try {
			Employees result = (Employees) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public Employees findById(java.lang.Integer id) {
		logger.log(Level.INFO, "getting Employees instance with id: " + id);
		try {
			Employees instance = (Employees) sessionFactory.getCurrentSession()
					.get("com.allinone.MyHibernateProject.northwind.dao.Employees", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(Employees instance) {
		logger.log(Level.INFO, "finding Employees instance by example");
		try {
			List<?> results = sessionFactory.getCurrentSession()
					.createCriteria("com.allinone.MyHibernateProject.northwind.dao.Employees").add(Example.create(instance))
					.list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}