package com.elcom.catalog.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.elcom.catalog.dataservice.root.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query(value="SELECT i FROM Item i  "
				+" LEFT JOIN FETCH i.itemBarCode ibc"
				+" WHERE i.id= ?1 ")
	Item findItem(Long id);	
	
}
