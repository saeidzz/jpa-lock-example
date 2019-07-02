package ir.rabbit.jpalock.jpalock.repository;

import ir.rabbit.jpalock.jpalock.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
