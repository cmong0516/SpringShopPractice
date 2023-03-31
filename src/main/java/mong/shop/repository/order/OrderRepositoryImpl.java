package mong.shop.repository.order;


import static mong.shop.domain.entity.QItem.item;
import static mong.shop.domain.entity.QOrder.order;
import static mong.shop.domain.entity.QUser.user;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mong.shop.domain.dto.request.OrderSearch;
import mong.shop.domain.dto.request.OrderStatus;
import mong.shop.domain.dto.response.OrderResponseDto;
import mong.shop.domain.dto.response.QItemResponseDto;
import mong.shop.domain.dto.response.QMemberResponseDto;
import mong.shop.domain.dto.response.QOrderResponseDto;
import mong.shop.domain.entity.Order;
import mong.shop.domain.entity.QOrder;
import mong.shop.domain.entity.QUser;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Order> findAll(OrderSearch orderSearch) {

        return jpaQueryFactory.select(order)
                .from(order)
                .join(order.user, user)
                .where(statusEq(orderSearch.getOrderStatus()),
                        nameLike(orderSearch.getMemberName()))
                .limit(1000)
                .fetch();

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

        return user.name.like(nameCond);
    }
}
