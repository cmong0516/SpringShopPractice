package mong.shop.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mong.shop.domain.dto.request.MemberForm;
import mong.shop.domain.dto.request.MemberLoginDto;
import mong.shop.domain.entity.Member;
import mong.shop.exception.InvalidSigninInformation;
import mong.shop.repository.member.MemberJpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberJpaRepository memberJpaRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long signin(MemberLoginDto login) {
        Member member = memberJpaRepository.findByEmail(login.getEmail())
                .orElseThrow(RuntimeException::new);

        var matches = passwordEncoder.matches(login.getPassword(), member.getPassword());
        if (!matches) {
            throw new InvalidSigninInformation();
        }

        return member.getId();
    }

    public void signup(MemberForm form) {
        Optional<Member> memberOptional = memberJpaRepository.findByEmail(form.getEmail());
        if (memberOptional.isPresent()) {
            throw new RuntimeException();
        }

        String encryptedPassword = passwordEncoder.encode(form.getPassword());

        Member.builder()
                .email(signup.getEmail())
                .password(encryptedPassword)
                .name(signup.getName())
                .build();
        userRepository.save(user);
    }
}
