package mong.shop.domain.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import java.time.LocalDateTime;
import lombok.Data;
import mong.shop.domain.dto.request.OrderStatus;

@Data
public class OrderResponseDto {
    private Long id;
    private String userName;
    private String itemName;
    private Long orderPrice;
    private Long orderQuantity;
    private OrderStatus orderStatus;
    private LocalDateTime orderTime;

    @QueryProjection
    public OrderResponseDto(Long id,String userName, String itemName, Long orderPrice, Long orderQuantity,
                            OrderStatus orderStatus, LocalDateTime orderTime) {
        this.id = id;
        this.userName = userName;
        this.itemName = itemName;
        this.orderPrice = orderPrice * orderQuantity;
        this.orderQuantity = orderQuantity;
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;
    }
}
