package ToyProject3.LoginPage.register;


import ToyProject3.LoginPage.member.Member;
import ToyProject3.LoginPage.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RegisterController {


    private final MemberRepository memberRepository;

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "Register";
    }

    @PostMapping("/register")
    public String addRegister(@Validated @ModelAttribute("registerForm") RegisterForm form, BindingResult bindingResult){


        if(bindingResult.hasErrors()){
            log.info("회원가입 폼 작성 오류가 발생했습니다.");
            return "/register";
        }

        if(memberRepository.findByP_id(form.getPersonal_Id()).get().getPersonal_Id().equals(form.getPersonal_Id())){
            log.info("중복된 아이디 존재");
            bindingResult.rejectValue("Personal_Id", "existId","이미 등록된 아이디입니다.");
            return "/register";
        }

        if(!form.getPassword_Check().equals(form.getPassword())){
            log.info("비밀번호 확인 작성 오류가 발생하였습니다. \n 비밀번호 = {}, 비밀번호 확인 = {}",form.getPassword(),form.getPassword_Check());
            bindingResult.rejectValue("Password_Check", "inconsistency","확인 비밀번호가 입력한 비밀번호와 일치하지 않습니다.");
            return "/register";
        }




        Member member = new Member();
        member.setPersonal_Id(form.getPersonal_Id());
        member.setPassword(form.getPassword());
        member.setName(form.getName());
        memberRepository.save(member);
        log.info("id = {}", memberRepository.findByP_id(form.getPersonal_Id()));
        return "redirect:/login";
    }


}
