package mong.shop.domain.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class ItemResponseDto {

    private Long id;
    private String name;
    private Long price;
    private int quantity;

    @QueryProjection
    public ItemResponseDto(Long id, String name, Long price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
