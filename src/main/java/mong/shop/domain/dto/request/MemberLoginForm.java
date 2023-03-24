package mong.shop.domain.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberLoginForm {

    @NotNull
    private String name;
    @NotNull
    private String password;
}
