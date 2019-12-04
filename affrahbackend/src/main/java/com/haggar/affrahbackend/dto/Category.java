package com.haggar.affrahbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	private String Name;
	private String description;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name="is_active")
	private boolean activate = true;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public boolean isActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", Name=" + Name + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", activate=" + activate + "]";
	}
	
	
	

}
