package mong.shop.service;

import lombok.RequiredArgsConstructor;
import mong.shop.domain.dto.request.MemberForm;
import mong.shop.domain.entity.User;
import mong.shop.repository.member.MemberJpaRepository;
import mong.shop.repository.member.MemberRepositoryCustom;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepositoryCustom memberRepositoryCustom;

    public void join(MemberForm memberForm) {

        User user = User.memberFormToUserEntity(memberForm);

        memberJpaRepository.save(user);
    }
}
