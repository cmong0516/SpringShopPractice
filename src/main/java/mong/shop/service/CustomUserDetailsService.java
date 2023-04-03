package mong.shop.service;

import lombok.RequiredArgsConstructor;
import mong.shop.repository.member.MemberJpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final MemberJpaRepository memberJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return memberJpaRepository.findByEmail(email)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("찾을수 없는 유저입니다."));
    }

    private UserDetails createUserDetails(User user){
        return User.builder()
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .build();
    }
}
