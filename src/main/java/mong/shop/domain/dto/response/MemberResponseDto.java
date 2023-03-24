package mong.shop.domain.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

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
}
