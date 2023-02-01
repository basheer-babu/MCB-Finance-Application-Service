package com.mcb.minifinanceltd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MCB_orders")
public class Orders {
	@Id
	@GeneratedValue
	private int id;
	private int uid;
	private String currency;
	private String quantity;
	private String price;
	
	@Override
	public String toString() {
		return "Orders [id=" + id + ", uid=" + uid + ", currency=" + currency + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
	
	
	
}
