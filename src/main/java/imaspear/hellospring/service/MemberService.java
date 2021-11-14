package imaspear.hellospring.service;

import imaspear.hellospring.domain.Member;
import imaspear.hellospring.repository.MemberRepository;
import imaspear.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Imaspear on 2021-10-24
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
  * <pre>
  *   imaspear.hellospring.service
  *   ㄴ MemberService.java
  * </pre>
  * @date : 2021-10-24 오후 7:45
  * @author : ImaSpear
  * @version : 1. 0. 0
  * @description : 회원 가입 기능
  * see :
  */
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /*
    * <pre>
    *   imaspear.hellospring.service
    *   ㄴ MemberService.java
    * </pre>
    * @date : 2021-10-24 오후 7:45
    * @author : ImaSpear
    * @version : 1. 0. 0
    * @description : 같은 이름이 있는 회원은 중복이기 때문에 회원 가입 불가능
    * see :
    */
    private void validateDuplicateMember(Member member) {
//        Optional<Member> result =
//                memberRepository.findByName(member.getName());
//        result.ifPresent(member1 -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        memberRepository.findByName(member.getName()).ifPresent(member1 -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /*
    * <pre>
    *   imaspear.hellospring.service
    *   ㄴ MemberService.java
    * </pre>
    * @date : 2021-10-24 오후 7:46
    * @author : ImaSpear
    * @version : 1. 0. 0
    * @description : 전체 회원 조회 기능
    * see :
    */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /*
    * <pre>
    *   imaspear.hellospring.service
    *   ㄴ MemberService.java
    * </pre>
    * @date : 2021-10-24 오후 7:47
    * @author : ImaSpear
    * @version : 1. 0. 0
    * @description : id를 이용한 검색 기능
    * see :
    */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

