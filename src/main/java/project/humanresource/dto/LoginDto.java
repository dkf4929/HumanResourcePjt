package project.humanresource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.servlet.http.HttpSession;

@AllArgsConstructor
@ToString
@Getter
public class LoginDto {

    private String loginId;
    private String empNm;
    private Long empId;
}
