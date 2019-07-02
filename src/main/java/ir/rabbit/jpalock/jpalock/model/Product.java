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
public class Product implements Serializable {
    private static final long serialVersionUID = 246079169723185271L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Version
    private Integer version;
    private String name;
    private long remainsQuantity;
    @OneToMany
    private List<Sale> sales;

    public Product(Integer version, String name, long remainsQuantity, List<Sale> sales) {
        this.version = version;
        this.name = name;
        this.remainsQuantity = remainsQuantity;
        this.sales = sales;
    }

    public Product(Integer version, String name, long remainsQuantity) {
        this.version = version;
        this.name = name;
        this.remainsQuantity = remainsQuantity;
    }
}
