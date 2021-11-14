package imaspear.hellospring.repository;

import imaspear.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Imaspear on 2021-10-24
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
