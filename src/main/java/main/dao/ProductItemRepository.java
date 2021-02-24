package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import main.entities.ProductItem;


@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
