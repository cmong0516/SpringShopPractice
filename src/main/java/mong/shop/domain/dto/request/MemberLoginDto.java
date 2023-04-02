package mong.shop.domain.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberLoginDto {

    @NotNull(message = "이메일을 입력해주세요.")
    private String email;
    @NotNull(message = "비밀번호를 입력해주세요.")
    private String password;

    @Builder
    public MemberLoginDto(String email,String password) {
        this.email = email;
        this.password = password;
    }
}
