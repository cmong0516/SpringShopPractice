package mong.shop.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mong.shop.domain.dto.request.CreateItemForm;
import mong.shop.domain.dto.request.ItemUpdateRequest;
import mong.shop.domain.dto.request.MemberForm;
import mong.shop.domain.dto.request.MemberLoginForm;
import mong.shop.domain.dto.response.ItemResponseDto;
import mong.shop.domain.dto.response.MemberResponseDto;
import mong.shop.service.ItemService;
import mong.shop.service.MemberService;
import mong.shop.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BaseController {

    private final MemberService memberService;
    private final ItemService itemService;
    private final OrderService orderService;

    @GetMapping("/")
    public String hello(@RequestParam(required = false) String message,Model model) {

        model.addAttribute("message", message);

        return "home";
    }

    @GetMapping("/members/new")
    public String signInPage(Model model) {

        model.addAttribute("memberForm", new MemberForm());

        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String signIn(@Valid MemberForm form, BindingResult bindingResult,Model model) {

        if (bindingResult.hasErrors()) {
            return "members/createMemberForm";
        }

        memberService.join(form);

        model.addAttribute("message", "회원가입이 완료되었습니다.");

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

        return "members/loginForm";
    }

    @GetMapping("/members")
    public String members(Model model) {

        List<MemberResponseDto> allMembers = memberService.findAll();

        model.addAttribute("members", allMembers);

        return "members/memberList";
    }

    @GetMapping("/items/new")
    public String newItemPage(Model model) {
        model.addAttribute("form", new CreateItemForm());
        return "/items/createItemForm";
    }

    @PostMapping("/items/new")
    public String addItem(@Valid CreateItemForm createItemForm, BindingResult result,Model model) {
        itemService.saveItem(createItemForm);

        model.addAttribute("message", "상품 등록이 완료되었습니다.");

        return "redirect:/";
    }

    @GetMapping("/items")
    public String itemListPage(Model model) {
        List<ItemResponseDto> allItems = itemService.findAllItems();

        model.addAttribute("items", allItems);

        return "/items/itemList";
    }

    @GetMapping("/items/update")
    public String updateItemPage(Model model) {
        model.addAttribute("form", new CreateItemForm());
        return "/items/updateItemForm";
    }

    @GetMapping("/items/{id}/edit")
    public String itemEditPage(@PathVariable Long id,Model model) {
        ItemResponseDto byId = itemService.findById(id);

        model.addAttribute("form", byId);

        return "items/updateItemForm";
    }

    @PostMapping("/items/{id}/edit")
    public String itemUpdate(@PathVariable Long id, ItemUpdateRequest itemUpdateRequest,Model model) {

        ItemResponseDto itemResponseDto = itemService.updateItem(itemUpdateRequest);

        model.addAttribute("form", itemResponseDto);
        model.addAttribute("message", "상품 정보 변경이 완료되었습니다.");

        return "redirect:/";
    }

    @GetMapping("/order")
    public String orderPage(Model model) {

        List<MemberResponseDto> allMembers = memberService.findAll();
        List<ItemResponseDto> allItems = itemService.findAllItems();

        model.addAttribute("members", allMembers);
        model.addAttribute("items", allItems);

        return "order/orderForm";
    }

    @PostMapping("/order")
    public String orderItem(@RequestParam("memberId") Long memberId, @RequestParam("itemId") Long itemId,
                            @RequestParam("count") Long count,Model model) {

        orderService.order(memberId,itemId,count);
        model.addAttribute("message", "주문이 완료되었습니다.");
        return "redirect:/";
    }
}
