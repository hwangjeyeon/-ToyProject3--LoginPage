package ToyProject3.LoginPage.member;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class Member {


    private Long id;

    private String Personal_Id;
    private String Password;
    private String name;


}
