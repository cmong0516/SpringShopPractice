package mong.shop.domain.dto.request;

import javax.validation.constraints.NotEmpty;
import lombok.Data;
import mong.shop.domain.entity.Member;

@Data
public class MemberForm {

    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;

}
