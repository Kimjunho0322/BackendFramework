package SchoolProject.Backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "backend")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 ID 값을 관리
    private Long id;  // 고유 식별자 필드 추가

    @Column(name = "country")
    private String country;

    @Column(name = "name")
    private String name;

    @Column(name = "dormitory")
    private String dormitory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberEntity that = (MemberEntity) o;
        return Objects.equals(country, that.country) &&
                Objects.equals(dormitory, that.dormitory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, dormitory);
    }

}
