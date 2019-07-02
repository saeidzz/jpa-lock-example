package ir.rabbit.jpalock.jpalock.repository;

import ir.rabbit.jpalock.jpalock.model.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends CrudRepository<Sale,Integer> {

}
