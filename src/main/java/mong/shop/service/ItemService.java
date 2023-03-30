package mong.shop.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mong.shop.domain.dto.request.CreateItemForm;
import mong.shop.domain.dto.response.ItemResponseDto;
import mong.shop.domain.entity.Item;
import mong.shop.repository.item.ItemJpaRepository;
import mong.shop.repository.item.ItemRepositoryCustom;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemJpaRepository itemJpaRepository;
    private final ItemRepositoryCustom itemRepositoryCustom;

    public void saveItem(CreateItemForm form) {
        Item item = new Item(form);

        itemJpaRepository.save(item);

    }

    public List<ItemResponseDto> findAllItems() {
        return itemRepositoryCustom.findAllItems();
    }

    public ItemResponseDto findById(Long id) {
        return itemRepositoryCustom.findById(id);
    }
}
