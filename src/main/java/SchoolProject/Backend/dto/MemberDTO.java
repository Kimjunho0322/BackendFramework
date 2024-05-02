package SchoolProject.Backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString


public class MemberDTO {
    private Long id;
    private String country;
    private String dormitory;
}


