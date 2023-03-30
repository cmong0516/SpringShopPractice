package mong.shop.service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mong.shop.domain.entity.Item;
import mong.shop.domain.entity.Order;
import mong.shop.domain.entity.User;
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
        User user = memberJpaRepository.findById(memberId).get();
        Item item = itemJpaRepository.findById(itemId).get();

        Order order = new Order(user);
        order.addItems(item,count);
        orderJpaRepository.save(order);

        item.order(count);
    }
}
