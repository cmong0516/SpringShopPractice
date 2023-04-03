package mong.shop.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mong.shop.domain.dto.request.MemberForm;
import mong.shop.domain.dto.response.MemberResponseDto;
import mong.shop.domain.entity.User;
import mong.shop.login.JwtTokenProvider;
import mong.shop.login.TokenInfo;
import mong.shop.repository.member.MemberJpaRepository;
import mong.shop.repository.member.MemberRepositoryCustom;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService{

    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepositoryCustom memberRepositoryCustom;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    public void join(MemberForm memberForm) {

        memberForm.setPassword(passwordEncoder.encode(memberForm.getPassword()));

        User user = User.memberFormToUserEntity(memberForm);

        memberJpaRepository.save(user);
    }

    public List<MemberResponseDto> findAll() {
        return memberRepositoryCustom.findAllMembers();
    }

    public TokenInfo login(String memberId, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                memberId, password);

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        return jwtTokenProvider.generateToken(authentication);
    }

}
