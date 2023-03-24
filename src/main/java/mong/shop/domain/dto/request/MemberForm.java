package mong.shop.domain.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class MemberForm {

    @NotNull
    private String name;
    @NotNull
    private String city;
    @NotNull
    private String street;
    @NotNull
    private String zipcode;
}
