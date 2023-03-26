package mong.shop.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mong.shop.domain.dto.request.CreateItemForm;

@Entity
@Getter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long price;
    private int quantity;

    @Builder
    public Item(String name, Long price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(CreateItemForm form) {
        this.name = form.getName();
        this.price = form.getPrice();
        this.quantity = form.getStockQuantity();
    }
}
