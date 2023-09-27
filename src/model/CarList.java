package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cameron Mockobee - cmockobee1@dmacc.edu
 * CIS175 - Fall 2023
 * Sep 8, 2023
 */

@Entity
@Table(name ="cars")
public class CarList {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="BRAND")
	private String brand;
	@Column(name="MODEL")
	private String model;
	
	public CarList() {
		super();
	}

	public CarList(String brand, String model) {
		super();
		this.brand = brand;
		this.model = model;
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
	 * @return the make
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param make the make to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String returnCarInfo() {
		return this.brand + ": " + this.model;
	}
	
}
