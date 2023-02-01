package com.mcb.minifinanceltd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MCB_Products")
public class MCB_products {

	@Id
	@GeneratedValue
	private int id;
	private String Uid;
	private String Name;
	private String Description;
	private String Image;
	private String Charge;
	private String TermsAndConditions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUid() {
		return Uid;
	}

	public void setUid(String uid) {
		Uid = uid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getCharge() {
		return Charge;
	}

	public void setCharge(String charge) {
		Charge = charge;
	}

	public String getTermsAndConditions() {
		return TermsAndConditions;
	}

	public void setTermsAndConditions(String termsAndConditions) {
		TermsAndConditions = termsAndConditions;
	}

	@Override
	public String toString() {
		return "MCB_products [id=" + id + ", Uid=" + Uid + ", Name=" + Name + ", Description=" + Description
				+ ", Image=" + Image + ", Charge=" + Charge + ", TermsAndConditions=" + TermsAndConditions + "]";
	}

}
