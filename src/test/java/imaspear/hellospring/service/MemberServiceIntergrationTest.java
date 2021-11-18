package imaspear.hellospring.service;

import imaspear.hellospring.domain.Member;
import imaspear.hellospring.repository.MemberRepository;
import imaspear.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.predicate;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Imaspear on 2021-10-24
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@SpringBootTest
@Transactional
class MemberServiceIntergrationTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    // @Transactional 이 어노테이션을 이용하면 데이터베이스에 커밋하지 않고 테스트 할 수 있다.
    // 원래 존재하는 데이터베이스와 중복이면 물론 실행되지 않지만, 존재하는 데이터와 중복되지 않는다면 사용 가능하다.
    // 데이터베이스에 저장되지 않은 데이터를 테스트하면 Rollback 해줘서 같은 데이터를 계속 테스트 해줄 수 있다.
    // jpa를 사용하려면 transactional 어노테이션을 추가해야한다.
    @Test
     public void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello1");
        //wher
        Long saveId = memberService.join(member);
        // then
        Member findMember = memberService.findOne(saveId).get();
        //member의 객체와 findMemver의 객체는 서로 다르다!!
        // 데이터 안에 존재하는 값을 비교해야 한다.
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}