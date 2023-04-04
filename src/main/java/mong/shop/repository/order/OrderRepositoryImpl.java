package mong.shop.repository.order;

import static mong.shop.domain.entity.QItem.item;
import static mong.shop.domain.entity.QMember.*;
import static mong.shop.domain.entity.QOrder.order;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mong.shop.domain.dto.request.OrderSearch;
import mong.shop.domain.dto.request.OrderStatus;
import mong.shop.domain.dto.response.OrderResponseDto;
import mong.shop.domain.dto.response.QOrderResponseDto;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<OrderResponseDto> findOrderByName(OrderSearch orderSearch) {
        return jpaQueryFactory.select(new QOrderResponseDto(order.id,order.member.name, order.item.name,order.totalPrice,order.quantity,
                order.orderStatus, order.createdDate))
                .from(order)
                .where(nameLike(orderSearch.getMemberName()))
                .where(statusEq(orderSearch.getOrderStatus()))
                .join(order.item, item)
                .join(order.member, member)
                .fetch();
    }

    @Override
    public OrderResponseDto findOrder(Long id) {
        return jpaQueryFactory.select(new QOrderResponseDto(order.id,order.member.name,order.item.name,order.totalPrice,order.quantity,order.orderStatus,order.createdDate))
                .from(order)
                .where(order.id.eq(id))
                .join(order.item, item)
                .join(order.member,member)
                .fetchOne();
    }


    private BooleanExpression statusEq(OrderStatus orderStatus) {
        if (orderStatus == null) {
            return null;
        }

        return order.orderStatus.eq(orderStatus);
    }

    private BooleanExpression nameLike(String nameCond) {
        if (!StringUtils.hasText(nameCond)) {
            return null;
        }

        return member.name.like(nameCond);
    }


}
