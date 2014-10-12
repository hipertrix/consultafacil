package com.consultafacil.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern; 

import java.io.Serializable; 





import org.hibernate.validator.constraints.Length; 
 

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 4548298563023480676L;

 
	@Id 
	@GeneratedValue
	private Long id;
	
	
	@NotNull
	@Length(min = 3, max = 20)
	@Pattern(regexp = "[a-z0-9_]+", message = "{invalid_login}")
	private String login; 
	

	@NotNull
	@Length(min = 6, max = 20)
	private String pwd;

	@NotNull
	@Length(min = 3, max = 100)
	private String name;
	
	
	 
 
	private String crm;
	private int gender;
	private String phone;
	private String email;
	 
	private String address;
	private String address_number;
	private String neighborhood;
	private String city;
	private String state;
	private String zip_code;
	private String birth;
	private String blood_type;
	private String allergic;
	private Date created_at;
	private int user_type;
	private int parent_id;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress_number() {
		return address_number;
	}
	public void setAddress_number(String address_number) {
		this.address_number = address_number;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getBlood_type() {
		return blood_type;
	}
	public void setBlood_type(String blood_type) {
		this.blood_type = blood_type;
	}
	public String getAllergic() {
		return allergic;
	}
	public void setAllergic(String allergic) {
		this.allergic = allergic;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	
	 
 
}