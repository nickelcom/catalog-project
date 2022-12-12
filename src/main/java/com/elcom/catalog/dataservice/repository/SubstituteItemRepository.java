package com.elcom.catalog.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elcom.catalog.dataservice.root.SubstituteItem;


@Repository
@Transactional

public interface SubstituteItemRepository extends JpaRepository<SubstituteItem, Long> {

}
