package project.humanresource.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginParamDto {
    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;
}
