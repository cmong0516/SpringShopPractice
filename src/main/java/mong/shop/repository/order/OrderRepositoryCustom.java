package mong.shop.repository.order;

import java.util.List;
import mong.shop.domain.dto.request.OrderSearch;
import mong.shop.domain.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryCustom {
    List<Order> findOrderByName(OrderSearch orderSearch);
}
