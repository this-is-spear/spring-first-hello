//package imaspear.hellospring;
//
//import imaspear.hellospring.repository.MemberRepository;
//import imaspear.hellospring.repository.MemoryMemberRepository;
//import imaspear.hellospring.service.MemberService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Created by Imaspear on 2021-10-25
// * Blog : https://imspear.tistory.com/
// * Github : https://github.com/Imaspear
// */
//
//@Configuration
//public class SpringConfig {
//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
//}
