package mong.shop.service;

import javax.security.auth.login.LoginContext;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mong.shop.domain.dto.request.MemberLoginDto;
import mong.shop.domain.entity.User;
import mong.shop.exception.InvalidSigninInformation;
import mong.shop.repository.member.MemberJpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberJpaRepository memberJpaRepository;

    @Transactional
    public Long signIn(MemberLoginDto login) {
        User user = memberJpaRepository.findByName(login.getName()).
                orElseThrow(InvalidSigninInformation::new);


        return null;
    }
}
