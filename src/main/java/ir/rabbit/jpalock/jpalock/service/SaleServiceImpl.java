package ir.rabbit.jpalock.jpalock.service;

import ir.rabbit.jpalock.jpalock.model.Customer;
import ir.rabbit.jpalock.jpalock.model.Product;
import ir.rabbit.jpalock.jpalock.model.Sale;
import ir.rabbit.jpalock.jpalock.repository.CustomerRepository;
import ir.rabbit.jpalock.jpalock.repository.ProductRepository;
import ir.rabbit.jpalock.jpalock.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleRepository saleRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    @Transactional
    public boolean sale(int customerId, String productName, long quantity) {
        Customer customer = customerRepository.findById(customerId).get();
        Product product = productRepository.findByName(productName);
        if (product.getRemainsQuantity() >= quantity) {
            Sale sale = new Sale();
            sale.setCustomer(customer);
            sale.setProduct(product);
            sale.setQuantity(quantity);
            sale = saleRepository.save(sale);

            customer.getSales().add(sale);
            customerRepository.save(customer);

            product.setRemainsQuantity(product.getRemainsQuantity() - quantity);
            product.getSales().add(sale);
            productRepository.save(product);
        } else {
            throw new RuntimeException();
        }
        return true;
    }
}
