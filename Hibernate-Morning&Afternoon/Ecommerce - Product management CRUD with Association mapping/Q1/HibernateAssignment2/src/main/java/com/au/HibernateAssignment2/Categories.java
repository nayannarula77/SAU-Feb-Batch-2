package com.au.HibernateAssignment2;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categories")
public class Categories {
	@Id
	@Column(name="Category_Id")
	private int cid;
	@Column(name="Category_name")
	private String cname;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "Product_Id")
	private Product product;
	
	@ManyToMany(targetEntity = Supplier.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Categories_Supplier", 
	joinColumns = @JoinColumn(referencedColumnName = "Category_Id"), 
	inverseJoinColumns = @JoinColumn(referencedColumnName = "Supplier_Id"))
	private Set<Supplier> supplier;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<Supplier> getSupplier() {
		return supplier;
	}

	public void setSupplier(Set<Supplier> supplier) {
		this.supplier = supplier;
	}
	
	
	
	}

