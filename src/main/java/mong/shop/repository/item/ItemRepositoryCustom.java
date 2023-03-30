package mong.shop.repository.item;

import java.util.List;
import mong.shop.domain.dto.response.ItemResponseDto;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepositoryCustom {

    public List<ItemResponseDto> findAllItems();

    public ItemResponseDto findById(Long id);
}
