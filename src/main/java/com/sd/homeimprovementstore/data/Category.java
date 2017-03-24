package com.sd.homeimprovementstore.data;

public class Category {
	private int id;
	private String name;
	private String desrciption;
	
	public Category () {
	}
	
	public Category(int id, String name, String desrciption) {
		super();
		this.id = id;
		this.name = name;
		this.desrciption = desrciption;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", desrciption=" + desrciption + "]";
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

	public String getDesrciption() {
		return desrciption;
	}

	public void setDesrciption(String desrciption) {
		this.desrciption = desrciption;
	}
	
	
}
