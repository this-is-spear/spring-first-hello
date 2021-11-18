package imaspear.hellospring.repository;

import imaspear.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Imaspear on 2021-11-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

public interface SpringDataJpaRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
