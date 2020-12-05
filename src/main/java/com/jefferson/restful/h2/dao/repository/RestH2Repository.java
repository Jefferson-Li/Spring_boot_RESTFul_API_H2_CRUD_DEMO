package com.jefferson.restful.h2.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jefferson.restful.h2.dao.entity.RestH2Entity;

@Repository
public interface RestH2Repository extends JpaRepository<RestH2Entity, Long> {
	
}
