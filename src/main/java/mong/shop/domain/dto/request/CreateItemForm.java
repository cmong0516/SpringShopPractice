package mong.shop.domain.dto.request;

import lombok.Data;

@Data
public class CreateItemForm {
    private String name;
    private int price;
    private int stockQuantity;
}
