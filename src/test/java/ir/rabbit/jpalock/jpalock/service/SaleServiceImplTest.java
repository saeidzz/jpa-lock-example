package ir.rabbit.jpalock.jpalock.service;

import ir.rabbit.jpalock.jpalock.model.Customer;
import ir.rabbit.jpalock.jpalock.model.Product;
import ir.rabbit.jpalock.jpalock.model.Sale;
import ir.rabbit.jpalock.jpalock.repository.CustomerRepository;
import ir.rabbit.jpalock.jpalock.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.OptimisticLockException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SaleServiceImplTest {

    Customer customer;
    Product product;
    List<Sale> sales;
    @Autowired
    private SaleService saleService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void before() {
        customer = customerRepository.findById(1).get();
/*        customer.setName("saeid");
        customer.setLastName("zangeneh");
       customer= customerRepository.save(customer);*/

        product = productRepository.findByName("Security");
                /*
        product.setRemainsQuantity(1000);
        product.setName("Security");
        productRepository.save(product);*/
        sales = new ArrayList<>();
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));
        sales.add(new Sale(customer, 10, product));
        sales.add(new Sale(customer, 20, product));


    }

    @Test
    public void sale() {
        sales.stream().forEach(sale -> {
            saleService.sale(sale.getCustomer().getId(), sale.getProduct().getName(), sale.getQuantity());
        });
    }

    @Test(expected = OptimisticLockingFailureException.class)
    public void multiSales() {
        sales.stream().parallel().forEach(sale -> {
         saleService.sale(sale.getCustomer().getId(), sale.getProduct().getName(), sale.getQuantity());
        });

    }

}