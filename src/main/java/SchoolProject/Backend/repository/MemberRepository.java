package SchoolProject.Backend.repository;

import SchoolProject.Backend.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    @Query("SELECT DISTINCT m FROM MemberEntity m WHERE m.country = :country AND m.dormitory = :dormitory")
    List<MemberEntity> findByCountryAndDormitory(@Param("country") String country, @Param("dormitory") String dormitory);


}
