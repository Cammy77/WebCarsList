package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Region;

/**
 * Cameron Mockobee - cmockobee1@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 3, 2023
 */
public class RegionHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarsList");
	
	
	public void insertRegion(Region r) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Region> showAllRegions(){
		EntityManager em = emfactory.createEntityManager();
		List<Region> allRegions = em.createQuery("SELECT r FROM Region r").getResultList();
		return allRegions;
	}
	
	public Region findRegion(String rNameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Region> typedQuery = em.createQuery("select r from Region r where r.regionName = :selectedRegion", Region.class);
		
		typedQuery.setParameter("selectedRegion", rNameToLookUp);
		typedQuery.setMaxResults(1);
		
		Region foundRegion;
		try {
			foundRegion = typedQuery.getSingleResult();
		}catch(NoResultException ex) {
			foundRegion = new Region(rNameToLookUp);
		}
		em.close();
		
		return foundRegion;
	}
}
