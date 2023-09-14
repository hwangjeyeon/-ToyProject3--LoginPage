package ToyProject3.LoginPage.Login;


import ToyProject3.LoginPage.member.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/")
    public String home(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("Login") LoginForm form){
        return "Login";
    }

    @PostMapping("/login")
    public String loginTry(@ModelAttribute("Login") LoginForm form){
        Member loginPeople = loginService.login(form.getPersonal_Id(),form.getPassword(), form.getName());

        if(loginPeople == null){

            log.info("해당하는 계정이 없습니다");
            return "Login";
        }else{
            return "redirect:/login_ok";
        }
    }

    @GetMapping("login_ok")
    public String login_User(@ModelAttribute("Login") LoginForm form){
        return "Login_Ok";
    }
}
