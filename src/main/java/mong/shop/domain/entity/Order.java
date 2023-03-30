package mong.shop.domain.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private Long quantity;

    @OneToMany
    private List<Item> items = new ArrayList<>();

    public void addItems(Item item,Long quantity) {
        this.items.add(item);
        this.quantity = quantity;
    }

    public Order(User user) {
        this.user = user;
    }
}
