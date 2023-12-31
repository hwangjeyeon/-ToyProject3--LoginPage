package ToyProject3.LoginPage.Login;


import ToyProject3.LoginPage.member.Member;
import ToyProject3.LoginPage.member.MemberRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final MemberRepository memberRepository;
    @GetMapping("/")
    public String home(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("Login") LoginForm form){
        return "Login";
    }

    @PostMapping("/login")
    public String loginTry(@Validated @ModelAttribute("Login") LoginForm form, BindingResult bindingResult, HttpServletRequest request){



        //로그인 폼 작성 오류
        if(bindingResult.hasErrors()){
            log.info("로그인 폼 작성 오류가 발생했습니다.");
            return "/login";
        }

        Member loginPeople = loginService.login(form.getPersonal_Id(),form.getPassword(), form.getName());


        // 로그인 객체 검증
        if(loginPeople == null){
            log.info("해당하는 계정이 없습니다");
            bindingResult.reject("loginFail", "해당하는 계정이 없습니다.");
            return "/login";
        }

        // 세션 생성 -> 있으면 세션 반환, 없으면 새로운 세션 생성
        HttpSession session = request.getSession();
        session.setAttribute("User", loginPeople);
        return "redirect:/login_ok";
    }

    @GetMapping("/login_ok")
    public String login_User(@SessionAttribute(name="User", required = false) Member loginPeople, Model model){

        
        //세션에 사용자 데이터가 없는 없는 경우
        if(loginPeople == null){
            return "redirect:/login";
        }

        //세션이 있고 해당하는 사용자 데이터가 있는 경우 로그인 ok 페이지로 이동
        model.addAttribute("member", loginPeople);
        return "Login_Ok";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return "redirect:/login";
    }

    @GetMapping("/personal_page")
    public String personal_page(@SessionAttribute(name="User", required = false) Member loginPeople, Model model){
        model.addAttribute("member", loginPeople);
        return "Personal_Page";
    }
}
