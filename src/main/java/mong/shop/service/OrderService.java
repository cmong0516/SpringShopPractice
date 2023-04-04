package mong.shop.service;

import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mong.shop.domain.dto.request.OrderSearch;
import mong.shop.domain.dto.response.OrderResponseDto;
import mong.shop.domain.entity.Item;
import mong.shop.domain.entity.Member;
import mong.shop.domain.entity.Order;
import mong.shop.repository.item.ItemJpaRepository;
import mong.shop.repository.member.MemberJpaRepository;
import mong.shop.repository.order.OrderJpaRepository;
import mong.shop.repository.order.OrderRepositoryCustom;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final MemberJpaRepository memberJpaRepository;
    private final ItemJpaRepository itemJpaRepository;
    private final OrderJpaRepository orderJpaRepository;
    private final OrderRepositoryCustom orderRepositoryCustom;

    @Transactional
    public void order(Long memberId, Long itemId, Long count) {
        Member member = memberJpaRepository.findById(memberId).get();
        Item item = itemJpaRepository.findById(itemId).get();

        Order order = new Order(member);
        order.addItems(item,count);
        orderJpaRepository.save(order);

        item.order(count);
    }

    @Transactional
    public OrderResponseDto cancel(Long orderId) {
        Order order = orderJpaRepository.findById(orderId).get();
        order.cancel();

        return orderRepositoryCustom.findOrder(orderId);
    }

    public List<OrderResponseDto> findOrders(OrderSearch orderSearch) {
        return orderRepositoryCustom.findOrderByName(orderSearch);
    }
}
