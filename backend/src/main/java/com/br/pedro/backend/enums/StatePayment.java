package com.br.pedro.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public enum StatePayment {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int code;
    private String description;

    public static StatePayment toEnum(Integer code){
        return Arrays.stream(StatePayment.values()).filter(statePayment -> statePayment.code == code).collect(Collectors.toList()).get(0);
    }
}
