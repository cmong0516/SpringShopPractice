package mong.shop.domain.dto.request;

import lombok.Data;

@Data
public class MemberLoginForm {

    private String name;
    private String password;
}
