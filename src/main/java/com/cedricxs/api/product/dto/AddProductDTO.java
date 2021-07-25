package com.cedricxs.api.product.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Tolerate;

import java.io.Serializable;

/**
 * @author chaxingshuo
 * @date 2021/07/25
 */
@Data
@Builder
public class AddProductDTO implements Serializable {

    @Tolerate
    AddProductDTO() {

    }
    private String name;

    private Double price;
}
