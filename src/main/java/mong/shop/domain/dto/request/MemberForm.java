package mong.shop.domain.dto.request;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MemberForm {

    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;

}
