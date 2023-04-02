package mong.shop.domain.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberLoginForm {

    @NotNull
    private String email;
    @NotNull
    private String password;
}
