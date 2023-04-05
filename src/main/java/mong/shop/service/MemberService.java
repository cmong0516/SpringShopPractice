package mong.shop.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mong.shop.domain.dto.request.MemberForm;
import mong.shop.domain.dto.response.MemberResponseDto;
import mong.shop.domain.entity.Member;
import mong.shop.repository.member.MemberJpaRepository;
import mong.shop.repository.member.MemberRepositoryCustom;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService{

    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepositoryCustom memberRepositoryCustom;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;


    public void join(MemberForm memberForm) throws Exception {

        if (memberJpaRepository.findByEmail(memberForm.getEmail()).isPresent()) {
            throw new Exception("이미 존재하는 이메일 입니다.");
        }



        memberForm.setPassword(passwordEncoder.encode(memberForm.getPassword()));
        Member member = new Member(memberForm);
        memberJpaRepository.save(member);
    }

    public List<MemberResponseDto> findAll() {
        return memberRepositoryCustom.findAllMembers();
    }




}
