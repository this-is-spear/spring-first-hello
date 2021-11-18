package imaspear.hellospring;

import imaspear.hellospring.domain.Member;
import imaspear.hellospring.repository.JDBCTemplateMemberRepository;
import imaspear.hellospring.repository.JPAMemberRepository;
import imaspear.hellospring.repository.MemberRepository;
import imaspear.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 * Created by Imaspear on 2021-10-25
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

}
