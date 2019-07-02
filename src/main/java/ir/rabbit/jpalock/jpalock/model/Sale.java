package ir.rabbit.jpalock.jpalock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
@NoArgsConstructor
public class Sale implements Serializable {

    private static final long serialVersionUID = 8234249558288476103L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Customer customer;
    private long quantity;
    @ManyToOne
    private Product product;

    public Sale(Customer customer, long quantity, Product product) {
        this.customer = customer;
        this.quantity = quantity;
        this.product = product;
    }
}
