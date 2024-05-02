package SchoolProject.Backend.entity;

import SchoolProject.Backend.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String country;

    @Column
    private String dormitory;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setCountry(memberDTO.getCountry());
        memberEntity.setDormitory(memberDTO.getDormitory());
        return memberEntity;
    }

}