package org.example.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HandlerRequestDTO {
    private Long mdmCode;
    private String correspondId;
}
