package mong.shop.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mong.shop.domain.dto.request.MemberForm;
import mong.shop.domain.dto.request.MemberLoginForm;
import mong.shop.domain.dto.response.MemberResponseDto;
import mong.shop.domain.entity.User;
import mong.shop.exception.PasswordException;
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

    public void login(MemberLoginForm form) throws PasswordException {
        User byName = memberJpaRepository.findByName(form.getName());

        if (!byName.getPassword().equals(form.getPassword())) {
            throw new PasswordException();
        }
    }

    public List<MemberResponseDto> findAll() {
        return memberRepositoryCustom.findAllMembers();
    }
}
