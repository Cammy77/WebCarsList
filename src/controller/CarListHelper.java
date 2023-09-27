package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarList;

/**
 * Cameron Mockobee - cmockobee1@dmacc.edu
 * CIS175 - Fall 2023
 * Sep 8, 2023
 */
public class CarListHelper {
	static EntityManagerFactory emfactory =  Persistence.createEntityManagerFactory("CarsList");
	
	public void insertCar(CarList cl) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cl);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CarList> showAllCars(){
		EntityManager em = emfactory.createEntityManager();
		List<CarList> allItems = em.createQuery("SELECT c FROM CarList c").getResultList();
		return allItems;
	}
	
	public void deleteCar(CarList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarList> typedQuery = em.createQuery("select cl from CarList cl where cl.brand = :selectedBrand and cl.model = :selectedModel", CarList.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedBrand", toDelete.getBrand());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		CarList result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public CarList searchForCarById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CarList found = em.find(CarList.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateCar(CarList toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param brand
	 * @return
	 */
	public List<CarList> searchForCarByBrand(String brand) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarList> typedQuery = em.createQuery("select cl from CarList cl where cl.brand = :selectedBrand", CarList.class);
		typedQuery.setParameter("selectedBrand", brand);
		List<CarList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
		
	}

	/**
	 * @param model
	 * @return
	 */
	public List<CarList> searchForCarByModel(String model) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarList> typedQuery = em.createQuery("select cl from CarList cl where cl.model = :selectedModel", CarList.class);
		typedQuery.setParameter("selectedModel", model);
		List<CarList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}

