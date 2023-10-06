package spring.data.entity;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@Accessors(chain = true)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp date;

    private String productName;
    private Double cost;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<Product> products;

//    public Order() {
//
//    }
//
//    public Order(List<Product> products) {
//        this.products = products;
//    }

}
