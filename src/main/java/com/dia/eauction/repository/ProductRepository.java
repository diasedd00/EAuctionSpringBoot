package com.dia.eauction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dia.eauction.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
