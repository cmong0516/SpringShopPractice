package mong.shop.service;

import lombok.RequiredArgsConstructor;
import mong.shop.domain.entity.Item;
import mong.shop.domain.entity.User;
import mong.shop.repository.item.ItemJpaRepository;
import mong.shop.repository.member.MemberJpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final MemberJpaRepository memberJpaRepository;
    private final ItemJpaRepository itemJpaRepository;

    public void order(Long memberId, Long itemId, Long count) {
        User user = memberJpaRepository.findById(memberId).get();
        Item item = itemJpaRepository.findById(itemId).get();
    }
}
