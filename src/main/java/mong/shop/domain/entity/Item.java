package mong.shop.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mong.shop.Auditing.BaseTimeEntity;
import mong.shop.domain.dto.request.CreateItemForm;
import mong.shop.domain.dto.request.ItemUpdateRequest;

@Entity
@Getter
@NoArgsConstructor
public class Item extends BaseTimeEntity {

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

    public Item updateItem(ItemUpdateRequest itemUpdateRequest) {
        this.id = itemUpdateRequest.getId();
        this.name = itemUpdateRequest.getName();
        this.price = itemUpdateRequest.getPrice();
        this.quantity = itemUpdateRequest.getQuantity();

        return this;
    }

    public void order(Long count) {
        this.quantity -= count;
    }

    public void orderCancel(Long count) {
        this.quantity += count;
    }
}
