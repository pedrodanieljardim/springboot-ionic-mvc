package com.br.pedro.backend.services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {
    private Integer status;
    private String msg;
    private Long timeStamp;
}
