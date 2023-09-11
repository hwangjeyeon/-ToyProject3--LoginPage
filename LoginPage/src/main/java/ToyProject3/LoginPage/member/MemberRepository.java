package ToyProject3.LoginPage.member;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();

    private static Long sequence = 0L;

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        log.info("저장된 멤버 = {}", member);
        log.info("저장된 멤버 개인아이디 = {}", member.getPersonal_Id());
        log.info("저장된 멤버 이름 = {}", member.getName());
        return member;
    }

    public Member findBy_Id(Long memberId){
        return store.get(memberId);
    }

    public Optional<Member> findByP_id(String loginId){
            return findAll().stream()
                    .filter(t -> t.getPersonal_Id().equals(loginId))
                    .findFirst();
    }

    public Optional<Member> findBy_name(String name){
            return findAll().stream()
                    .filter(t-> t.getName().equals(name))
                    .findAny();
    }
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }


    public void clearStore(){
        store.clear();
    }


}
