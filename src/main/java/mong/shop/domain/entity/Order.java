package mong.shop.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mong.shop.Auditing.BaseTimeEntity;
import mong.shop.domain.dto.request.OrderStatus;

@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
@Getter
public class Order extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    private Member member;

    private Long quantity;

    private OrderStatus orderStatus;

    private Long totalPrice;

    @OneToOne
    private Item item;

    public void addItems(Item item,Long quantity) {
        this.item = item;
        this.quantity = quantity;
        this.orderStatus = OrderStatus.ORDER;
        this.totalPrice = quantity * item.getPrice();
    }

    public Order(mong.shop.domain.entity.Member member) {
        this.member = member;
    }

    public void cancel() {
        this.orderStatus = OrderStatus.CANCEL;
        this.item.orderCancel(quantity);
    }
}
