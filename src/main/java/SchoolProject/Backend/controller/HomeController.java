package SchoolProject.Backend.controller;

import SchoolProject.Backend.dto.MemberDTO;
import SchoolProject.Backend.entity.MemberEntity;
import SchoolProject.Backend.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    private final MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String searchUniversities(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        String dormitory = (memberDTO.getDormitory() != null) ? memberDTO.getDormitory() : "No";
        List<MemberEntity> universities = memberService.findUniversitiesByCountryDormitoryAndPeriod(memberDTO.getCountry(), dormitory, memberDTO.getPeriod());
        if (universities.isEmpty()) {
            System.out.println("No universities found");
        } else {
            for (MemberEntity university : universities) {
                System.out.printf("Matching university: %s, Country: %s, Dormitory: %s, Period: %s\n",
                        university.getName(), university.getCountry(), university.getDormitory(), university.getPeriod());
            }
        }
        return "index";
    }
}
