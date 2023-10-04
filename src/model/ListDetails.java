package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Cameron Mockobee - cmockobee1@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 3, 2023
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate listDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Region region;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<CarList> listOfCars;
	
	public ListDetails() {
		super();
	}

	public ListDetails(int id, String listName, LocalDate listDate, Region region, List<CarList> listOfCars) {
		super();
		this.id = id;
		this.listName = listName;
		this.listDate = listDate;
		this.region = region;
		this.listOfCars = listOfCars;
	}

	public ListDetails(String listName, LocalDate listDate, Region region, List<CarList> listOfCars) {
		super();
		this.listName = listName;
		this.listDate = listDate;
		this.region = region;
		this.listOfCars = listOfCars;
	}

	public ListDetails(String listName, LocalDate listDate, Region region) {
		super();
		this.listName = listName;
		this.listDate = listDate;
		this.region = region;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}

	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}

	/**
	 * @return the listDate
	 */
	public LocalDate getListDate() {
		return listDate;
	}

	/**
	 * @param listDate the listDate to set
	 */
	public void setListDate(LocalDate listDate) {
		this.listDate = listDate;
	}

	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * @return the listOfCars
	 */
	public List<CarList> getListOfCars() {
		return listOfCars;
	}

	/**
	 * @param listOfCars the listOfCars to set
	 */
	public void setListOfCars(List<CarList> listOfCars) {
		this.listOfCars = listOfCars;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", listDate=" + listDate + ", region=" + region
				+ ", listOfCars=" + listOfCars + "]";
	}

	

}


