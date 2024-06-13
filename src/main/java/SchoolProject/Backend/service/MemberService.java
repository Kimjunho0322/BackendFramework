package SchoolProject.Backend.service;

import SchoolProject.Backend.entity.MemberEntity;
import SchoolProject.Backend.entity.UniversityEntity;
import SchoolProject.Backend.repository.MemberRepository;
import SchoolProject.Backend.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final UniversityRepository universityRepository;
    private static final Logger LOGGER = Logger.getLogger(MemberService.class.getName());

    @Autowired
    public MemberService(MemberRepository memberRepository, UniversityRepository universityRepository) {
        this.memberRepository = memberRepository;
        this.universityRepository = universityRepository;
    }

    public List<MemberEntity> findUniversitiesByCountryDormitoryAndPeriod(String country, String dormitory, String period) {
        List<MemberEntity> universities = memberRepository.findByCountryDormitoryAndPeriod(country, dormitory, period);
        System.out.println("Query returned " + universities.size() + " universities");

        for (MemberEntity university : universities) {
            System.out.println("University fetched: " + university.getName() + ", " + university.getCountry() + ", " + university.getDormitory() + ", Period: " + university.getPeriod());
        }
        return universities;
    }

    public void saveUniversities(List<MemberEntity> universities) {
        List<UniversityEntity> universityEntities = universities.stream().map(memberEntity -> {
            UniversityEntity universityEntity = new UniversityEntity();
            universityEntity.setName(memberEntity.getName());
            universityEntity.setCountry(memberEntity.getCountry());
            universityEntity.setDormitory(memberEntity.getDormitory());
            universityEntity.setPeriod(memberEntity.getPeriod());
            return universityEntity;
        }).collect(Collectors.toList());
        universityRepository.saveAll(universityEntities);
    }
}
