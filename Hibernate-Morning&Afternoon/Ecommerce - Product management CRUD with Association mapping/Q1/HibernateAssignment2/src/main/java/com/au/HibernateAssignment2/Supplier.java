package com.au.HibernateAssignment2;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Supplier")
public class Supplier {
	@Id
	@Column(name="Supplier_Id")
	private int sid;
	
	@Column(name="Supplier_Name")
	private String sname;
	
	@ManyToMany(targetEntity = Categories.class)
	@JoinColumn(referencedColumnName = "Supplier_Id")
	private Set<Categories> categories;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Set<Categories> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categories> categories) {
		this.categories = categories;
	}
	
	
	
}
