package ToyProject3.LoginPage.Login;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class LoginForm {


    @NotEmpty
    private String Personal_Id;
    @NotEmpty
    private String password;
    private String name;

}
