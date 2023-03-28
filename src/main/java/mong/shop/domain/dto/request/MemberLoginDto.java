package mong.shop.domain.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberLoginDto {

    @NotNull(message = "아이디를 입력해주세요.")
    private String name;
    @NotNull(message = "비밀번호를 입력해주세요.")
    private String password;

    @Builder
    public MemberLoginDto(String name,String password) {
        this.name = name;
        this.password = password;
    }
}
