package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cameron Mockobee - cmockobee1@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 3, 2023
 */
@Entity
@Table(name="region")
public class Region{
	@Id
	@GeneratedValue
	private int id;
	private String regionName;
	
	public Region() {
		super();
	}

	public Region(int id, String regionName) {
		super();
		this.id = id;
		this.regionName = regionName;
	}

	public Region(String regionName) {
		super();
		this.regionName = regionName;
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
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @param regionName the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", regionName=" + regionName + "]";
	}
	
	
}
