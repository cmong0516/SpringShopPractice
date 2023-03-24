package mong.shop.controller;

import mong.shop.domain.dto.request.MemberForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String hello() {
        return "home";
    }

    @GetMapping("/members/new")
    public String signIn(Model model) {

        model.addAttribute("memberForm", new MemberForm());

        return "members/createMemberForm";
    }
}
