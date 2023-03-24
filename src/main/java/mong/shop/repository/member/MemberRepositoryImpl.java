package mong.shop.repository.member;

import static mong.shop.domain.entity.QUser.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mong.shop.domain.dto.response.MemberResponseDto;
import mong.shop.domain.dto.response.QMemberResponseDto;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<MemberResponseDto> findAllMembers() {

        return jpaQueryFactory.select(new QMemberResponseDto(user.id,user.name, user.email))
                .from(user)
                .fetch();
    }
}
