package mong.shop.repository.item;

import static mong.shop.domain.entity.QItem.item;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mong.shop.domain.dto.response.ItemResponseDto;
import mong.shop.domain.dto.response.QItemResponseDto;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ItemResponseDto> findAllItems() {
        return jpaQueryFactory.select(new QItemResponseDto(item.id, item.name, item.price, item.quantity))
                .from(item)
                .fetch();
    }
}
