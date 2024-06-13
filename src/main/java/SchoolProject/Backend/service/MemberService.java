package SchoolProject.Backend.service;

import SchoolProject.Backend.entity.MemberEntity;
import SchoolProject.Backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private static final Logger LOGGER = Logger.getLogger(MemberService.class.getName());

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberEntity> findUniversitiesByCountryDormitoryAndPeriod(String country, String dormitory, String period) {
        List<MemberEntity> universities = memberRepository.findByCountryDormitoryAndPeriod(country, dormitory, period);
        System.out.println("Query returned " + universities.size() + " universities");

        for (MemberEntity university : universities) {
            System.out.println("University fetched: " + university.getName() + ", " + university.getCountry() + ", " + university.getDormitory() + ", Period: " + university.getPeriod());
        }
        Set<MemberEntity> uniqueUniversities = new HashSet<>(universities);
        System.out.println("Unique universities count after removing duplicates: " + uniqueUniversities.size());

        for (MemberEntity uniqueUniversity : uniqueUniversities) {
            System.out.println("Unique university: " + uniqueUniversity.getName() + ", " + uniqueUniversity.getCountry() + ", " + uniqueUniversity.getDormitory() + ", Period: " + uniqueUniversity.getPeriod());
        }
        return new ArrayList<>(uniqueUniversities);
    }
}
