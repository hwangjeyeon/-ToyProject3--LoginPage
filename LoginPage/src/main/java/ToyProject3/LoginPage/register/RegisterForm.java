package ToyProject3.LoginPage.register;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
public class RegisterForm {
    @NotBlank
    @Size(min=4,max=12)
    private String Personal_Id;

    @NotBlank
    @Size(min=4,max=12)
    private String password;

    @NotBlank
    private String Password_Check;

    @NotBlank
    @Size(min=1,max=50)
    private String name;

}
