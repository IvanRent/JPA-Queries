package org.dao.sregion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.modelo.sregion.Region_22;

public class DaoS_Region {
	
	public static void insert(){
		//EntityManager = sessionFActory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAQueries");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			Region_22 region = new Region_22();
			region.setId(5);
			region.setName("Puto");
			em.persist(region);
			em.getTransaction().commit();
			
		} catch (HibernateException e) {
			System.out.println("Exception insert: "+ e.getMessage());
			em.getTransaction().rollback();
		}
		
	}
	public static void update(){
		//EntityManager = sessionFActory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAQueries");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			Region_22 region = new Region_22();
			region.setId(2);
			region.setName("Putos");
			em.merge(region);
			em.getTransaction().commit();
			
		} catch (HibernateException e) {
			System.out.println("Exception update: "+ e.getMessage());
			em.getTransaction().rollback();
		}
		
	}
	public static void delete(){
		//EntityManager = sessionFActory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAQueries");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			Region_22 region = em.find(Region_22.class, 1);
			 if(region == null)
			 {
				System.out.println("El registro no existe"); 
			 }else{
				 em.remove(region);
				 em.getTransaction().commit();
			 }
						
		} catch (HibernateException e) {
			System.out.println("Exception delete: "+ e.getMessage());
			em.getTransaction().rollback();
		}
		
	}
	public static void select(){
		//EntityManager = sessionFActory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAQueries");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("select a from Region_22 a");
			@SuppressWarnings("unchecked")
			List<Region_22> list = query.getResultList();
			
			 for(Region_22 x : list)
			 {
				System.out.println(x.getId()+","+x.getName()); 
			 }
			 em.getTransaction().commit();
			
						
		} catch (HibernateException e) {
			System.out.println("Exception select: "+ e.getMessage());
			em.getTransaction().rollback();
		}
		
	}
	
	
	////////////////////////////////////////////////////////////
	////////////////Consulta almacenada////////////////////////////
	/* ventajas
	 * no se repiten las consultas
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static void consultaAlmacenada(){
		//EntityManager = sessionFActory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAQueries");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			//Query query = em.createQuery("select a from Region_22 a");
			Query query = em.createNamedQuery("SELECT_ALL_REGION_2");
			@SuppressWarnings("unchecked")
			List<Region_22> list = query.getResultList();
			
			 for(Region_22 x : list)
			 {
				System.out.println(x.getId()+","+x.getName()); 
			 }
			 em.getTransaction().commit();
			
						
		} catch (HibernateException e) {
			System.out.println("Exception select: "+ e.getMessage());
			em.getTransaction().rollback();
		}
		
	}
	
	public static void main(String[] args) {
		insert();
		//update();
		//delete();
		//select();
		//consultaAlmacenada();
	}

}
