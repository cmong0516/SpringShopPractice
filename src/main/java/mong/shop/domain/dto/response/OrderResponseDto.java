package mong.shop.domain.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import mong.shop.domain.entity.Order;

@Data
public class OrderResponseDto {
    private Long id;
    private MemberResponseDto memberResponseDto;
    private ItemResponseDto itemResponseDto;

    @QueryProjection
    public OrderResponseDto(Long id,MemberResponseDto memberResponseDto,
                            ItemResponseDto itemResponseDto) {
        this.id = id;
        this.memberResponseDto = memberResponseDto;
        this.itemResponseDto = itemResponseDto;
    }

    public OrderResponseDto(Order order) {
        this.id = order.getId();
        this.memberResponseDto = new MemberResponseDto(order.getUser());
        this.itemResponseDto = new ItemResponseDto(order.getItem());
    }
}
