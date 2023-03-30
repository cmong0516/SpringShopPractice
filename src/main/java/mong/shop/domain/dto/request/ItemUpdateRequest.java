package mong.shop.domain.dto.request;

import lombok.Data;

@Data
public class ItemUpdateRequest {

    private Long id;
    private String name;
    private Long price;
    private Long quantity;

}
