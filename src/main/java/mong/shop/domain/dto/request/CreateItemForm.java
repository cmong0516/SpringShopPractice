package mong.shop.domain.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateItemForm {
    @NotNull
    private String name;
    @NotNull
    private Long price;
    @NotNull
    private int stockQuantity;

}
