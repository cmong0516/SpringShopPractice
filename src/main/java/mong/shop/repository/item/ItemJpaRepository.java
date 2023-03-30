package mong.shop.repository.item;

import java.util.Optional;
import mong.shop.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemJpaRepository extends JpaRepository<Item,Long> {
    Optional<Item> findById(Long id);
}
