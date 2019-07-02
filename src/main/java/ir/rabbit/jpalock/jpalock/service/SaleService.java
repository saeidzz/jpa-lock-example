package ir.rabbit.jpalock.jpalock.service;

import org.springframework.transaction.annotation.Transactional;

public interface SaleService {
    boolean sale(int customerId, String productName, long quantity);
}
