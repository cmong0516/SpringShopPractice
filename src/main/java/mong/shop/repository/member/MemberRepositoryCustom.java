package mong.shop.repository.member;

import java.util.List;
import mong.shop.domain.dto.response.MemberResponseDto;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepositoryCustom {
    List<MemberResponseDto> findAllMembers();
}
