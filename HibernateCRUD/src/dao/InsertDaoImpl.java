package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.InsertVo;



public class InsertDaoImpl implements InsertDao {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	Session session =sessionFactory.openSession();


	
	
	public void insert(InsertVo insertVo) {
		
		try
		{
			
			Transaction tr = session.beginTransaction();
			
			session.save(insertVo);
			
			System.out.println("Before log4j configuration");
		
			DOMConfigurator.configure("C:/Users/darshan/workspace/HibernateCRUD/src/log4j.xml");
			
			System.out.println("After log4j configuration");
		    
		     
		    final Logger logger = Logger.getLogger(InsertDaoImpl.class);
		    
		    logger.info("List of User:: ID : "+insertVo.getId()+" First Name : "+insertVo.getFname()+" Last Name : "+insertVo.getLname()+" User Name : "+insertVo.getUname());
		        
		    tr.commit();
		    logger.info("DONE");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}




	public List view(InsertVo insertVo) {
		
		List user = new ArrayList();
		try
		{
			
			Query q1 = session.createQuery("from InsertVo ");
					
			user = q1.list();				
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return user;
	}
	
	public void delete(InsertVo insertVo)
	{
		
		try
		{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.delete(insertVo);
			
			session.getTransaction().commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
public List search(InsertVo insertVo) {
		
		List edituser = new ArrayList();
		try
		{
			
			Query q1 = session.createQuery("from InsertVo where id = '"+insertVo.getId()+"'");
					
			edituser = q1.list();				
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return edituser;
	}


public void update(InsertVo insertVo) {
	
		try
		{
			
			Transaction tr = session.beginTransaction();
			
			session.update(insertVo);
			
		    tr.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
