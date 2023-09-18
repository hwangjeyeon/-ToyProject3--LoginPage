package ToyProject3.LoginPage.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MemberRepositoryTest {

    private final MemberRepository memberRepository = new MemberRepository();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }


    @Test
    public void repositoryTest1(){
        //given
        Member member = new Member();
        member.setPersonal_Id("test2");
        member.setPassword("test2!");
        member.setName("테스터");

        //when
        Member SavedMember = memberRepository.save(member);


        //then
        Assertions.assertThat(SavedMember.getPersonal_Id()).isEqualTo(member.getPersonal_Id());
        Assertions.assertThat(SavedMember.getPassword()).isEqualTo(member.getPassword());
        Assertions.assertThat(SavedMember.getName()).isEqualTo(member.getName());
    }
}