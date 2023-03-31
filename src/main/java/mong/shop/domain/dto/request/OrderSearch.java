package mong.shop.domain.dto.request;

import lombok.Data;

@Data
public class OrderSearch {
    private String memberName;
    private OrderStatus orderStatus;
}
