package mong.shop.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mong.shop.domain.dto.request.MemberForm;
import mong.shop.domain.dto.request.MemberLoginForm;
import mong.shop.domain.dto.response.MemberResponseDto;
import mong.shop.exception.PasswordException;
import mong.shop.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BaseController {

    private final MemberService memberService;

    @GetMapping("/")
    public String hello() {
        return "home";
    }

    @GetMapping("/members/new")
    public String signInPage(Model model) {

        model.addAttribute("memberForm", new MemberForm());

        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String signIn(@Valid MemberForm form, BindingResult bindingResult, Model model) {

        log.info(form.getName());
        log.info(form.getPassword());
        log.info(form.getEmail());

        if (bindingResult.hasErrors()) {
            return "members/createMemberForm";
        }

        memberService.join(form);

        return "redirect:/";
    }

    @GetMapping("/members/login")
    public String loginPage(Model model) {
        model.addAttribute("memberLoginForm", new MemberLoginForm());

        return "members/loginForm";

    }

    @PostMapping("/members/login")
    public String signIn(@Valid MemberLoginForm form, BindingResult bindingResult, Model model) {

        log.info(form.getName());
        log.info(form.getPassword());

        if (bindingResult.hasErrors()) {
            return "members/loginForm";
        }

        try {
            memberService.login(form);
        } catch (PasswordException e) {
            model.addAttribute("exception",e);
        }

        return "members/loginForm";
    }

    @GetMapping("/members")
    public String members(Model model) {

        List<MemberResponseDto> allMembers = memberService.findAll();

        model.addAttribute("members", allMembers);

        return "members/memberList";
    }

    @GetMapping("/items/new")
    public String
}
