package mong.shop.service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mong.shop.domain.dto.request.MemberLoginDto;
import mong.shop.repository.member.MemberJpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberJpaRepository memberJpaRepository;

    @Transactional
    public Long signIn(MemberLoginDto login) {
        return null;
    }
}
