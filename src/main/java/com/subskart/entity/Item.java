package com.subskart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Component
@Data
public class Item {

	@Id
	@GeneratedValue
	private Long itemId;
	private String itemName;
	private Double pricePerUnit = 0.0;
	private int discount;

	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "category_id", referencedColumnName = "categoryId")
	private Category category;
}
