package mong.shop.domain.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import mong.shop.domain.entity.Member;

@Data
public class MemberResponseDto {
    private Long id;
    private String name;
    private String email;

    @QueryProjection
    public MemberResponseDto(Long id,String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
    }
}
