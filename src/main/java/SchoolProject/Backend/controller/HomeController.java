package SchoolProject.Backend.controller;

import SchoolProject.Backend.dto.MemberDTO;
import SchoolProject.Backend.entity.MemberEntity;
import SchoolProject.Backend.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {
    private final MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/search")
    public List<MemberEntity> searchUniversities(@RequestBody MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        String dormitory = (memberDTO.getDormitory() != null && memberDTO.getDormitory().equals("Yes")) ? "Yes" : "No";
        List<MemberEntity> universities = memberService.findUniversitiesByCountryDormitoryAndPeriod(memberDTO.getCountry(), dormitory, memberDTO.getPeriod());
        memberService.saveUniversities(universities); // 검색된 대학을 저장하는 메서드 호출
        return universities;
    }
}
