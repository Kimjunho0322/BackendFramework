package SchoolProject.Backend.controller;

import SchoolProject.Backend.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    //기본 페이지 요청
    @GetMapping("/")
    public String index(){
        return "index"; //templates 폴더의 index.html을 찾아감
    }

    @PostMapping("/")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        //memberService.save(memberDTO);
        return "index";
    };
}
