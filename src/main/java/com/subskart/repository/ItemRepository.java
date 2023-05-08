package com.subskart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.subskart.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query("From Item i order by i.category")
	public List<Item> itemSelection();

}
