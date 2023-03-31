package mong.shop.domain.dto.request;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderStatus {

    ORDER("주문"),
    CANCEL("취소");

    private String status;

    OrderStatus(String status) {
        this.status = status;
    }
}
