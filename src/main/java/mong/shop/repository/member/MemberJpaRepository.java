package mong.shop.repository.member;

import java.util.Optional;
import mong.shop.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByName(String name);
    Optional<Member> findByEmail(String name);
}
