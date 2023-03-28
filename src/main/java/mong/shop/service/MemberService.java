package mong.shop.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mong.shop.domain.dto.request.MemberForm;
import mong.shop.domain.dto.response.MemberResponseDto;
import mong.shop.domain.entity.User;
import mong.shop.repository.member.MemberJpaRepository;
import mong.shop.repository.member.MemberRepositoryCustom;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepositoryCustom memberRepositoryCustom;
    private final PasswordEncoder passwordEncoder;

    public void join(MemberForm memberForm) {

        memberForm.setPassword(passwordEncoder.encode(memberForm.getPassword()));

        User user = User.memberFormToUserEntity(memberForm);

        memberJpaRepository.save(user);
    }

    public List<MemberResponseDto> findAll() {
        return memberRepositoryCustom.findAllMembers();
    }
}
