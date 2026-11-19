package org.dcl.merchantproduct.dto;

import java.util.List;
import javax.persistence.*;

@Entity
public class Merchant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Mechant_name", nullable = false )
	private String name;
	@Column(name = "Mechant_GST_Number", nullable = false, unique = true)
	private String gstNum;
	@Column(name = "Mechant_Phone_Number", nullable = false, unique = true )
	private long phone;
	@Column(name = "Mechant_Email_Id", nullable = false )
	private String email;
	@Column(name = "Mechant_PWD", nullable = false, unique = true )
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "merchant")
	private List<Product> products;
	
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGstNum() {
		return gstNum;
	}
	public void setGstNum(String gstNum) {
		this.gstNum = gstNum;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Merchant [id=" + id + ", name=" + name + ", gstNum=" + gstNum + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	

}
