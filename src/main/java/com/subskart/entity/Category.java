package com.subskart.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Component
public class Category{

	@Id
	@GeneratedValue
	private Long categoryId;
	private String categoryName;

	@JsonBackReference
	@OneToMany(mappedBy = "category")
	private List<Item> items;

}
