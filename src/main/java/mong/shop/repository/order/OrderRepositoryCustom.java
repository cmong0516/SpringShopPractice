package mong.shop.repository.order;

import java.util.List;
import mong.shop.domain.dto.request.OrderSearch;
import mong.shop.domain.dto.response.OrderResponseDto;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryCustom {
    List<OrderResponseDto> findOrderByName(OrderSearch orderSearch);

    OrderResponseDto findOrder(Long id);
}
