package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="OrderTable")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String item;
	private int quanity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getQuanity() {
		return quanity;
	}
	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", item=" + item + ", quanity=" + quanity + "]";
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, String item, int quanity) {
		super();
		this.id = id;
		this.item = item;
		this.quanity = quanity;
	}
	public Order(String item, int quanity) {
		super();
		this.item = item;
		this.quanity = quanity;
	}

}
