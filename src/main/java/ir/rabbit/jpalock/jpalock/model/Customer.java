package ir.rabbit.jpalock.jpalock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {


    private static final long serialVersionUID = -7235157516988695683L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String lastName;

    @OneToMany
    private List<Sale> sales;

    public Customer(String name, String lastName, List<Sale> sales) {
        this.name = name;
        this.lastName = lastName;
        this.sales = sales;
    }

    public Customer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
