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
    private String dormitory;  // 문자열로 값을 받음

    // 이 메소드를 추가하여 내부적으로 boolean 값을 확인할 수 있도록 함
    public boolean isDormitoryAvailable() {
        return "Yes".equalsIgnoreCase(dormitory);
    }
}
