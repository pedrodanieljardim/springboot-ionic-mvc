package com.br.pedro.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum TypeClient {
    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(1, "Pessoa Jurídica");

    private Integer code;
    private String description;

    public static TypeClient toEnum(Integer code){
        return Arrays.stream(TypeClient.values()).filter(typeClient -> typeClient.code == code).collect(Collectors.toList()).get(0);
    }
}
