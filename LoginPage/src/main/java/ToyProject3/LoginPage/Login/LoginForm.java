package ToyProject3.LoginPage.Login;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class LoginForm {


    @NotBlank
    private String Personal_Id;
    @NotBlank
    private String password;

    private String password_check;

    @NotBlank
    private String name;

}
