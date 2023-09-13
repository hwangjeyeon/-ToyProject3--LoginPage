package ToyProject3.LoginPage.Login;


import ToyProject3.LoginPage.member.Member;
import ToyProject3.LoginPage.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    public Member login(String Personal_Id, String password, String name){
        return memberRepository.findByP_id(Personal_Id)
                .filter(m->m.getPassword().equals(password) && m.getName().equals(name))
                .orElse(null);
    }

}
