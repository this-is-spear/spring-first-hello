package imaspear.hellospring;

import imaspear.hellospring.repository.JDBCMemberRepository;
import imaspear.hellospring.repository.MemberRepository;
import imaspear.hellospring.repository.MemoryMemberRepository;
import imaspear.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Imaspear on 2021-10-25
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JDBCMemberRepository(dataSource);
    }
}
