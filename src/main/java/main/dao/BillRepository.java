package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import main.entities.Bill;


@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Long> {
}