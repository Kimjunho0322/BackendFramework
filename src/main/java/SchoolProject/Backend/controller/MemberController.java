package SchoolProject.Backend.controller;

import SchoolProject.Backend.dto.MemberDTO;
import SchoolProject.Backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {
    //생성자 주입
  //  private final MemberService memberService;


    //회원가입 출력 페이지
    @GetMapping("/member/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("member/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        //memberService.save(memberDTO);
        return "index";
    };

}
