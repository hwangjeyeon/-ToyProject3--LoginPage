package ToyProject3.LoginPage.testdata;


import ToyProject3.LoginPage.member.Member;
import ToyProject3.LoginPage.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestData {
    private final MemberRepository memberRepository;

    @PostConstruct
    public void tester_1(){

        Member member = new Member();
        member.setPersonal_Id("test1");
        member.setName("hwang");
        member.setPassword("test1!");
        memberRepository.save(member);
    }

}
