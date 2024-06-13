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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "name")
    private String name;

    @Column(name = "dormitory")
    private String dormitory;

    @Column(name = "period")
    private String period;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberEntity)) return false;
        MemberEntity that = (MemberEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(country, that.country) &&
                Objects.equals(dormitory, that.dormitory) &&
                Objects.equals(period, that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, dormitory, period);
    }
}
