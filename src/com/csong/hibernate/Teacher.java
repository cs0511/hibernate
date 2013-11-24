package com.csong.hibernate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	private int id;
	private String name;
	private String title;
	private Title jobTitle;
	/**
	 * @return id
	 */
	@Id
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
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Enumerated(EnumType.ORDINAL)
	public Title getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(Title jobTitle) {
		this.jobTitle = jobTitle;
	}



}
